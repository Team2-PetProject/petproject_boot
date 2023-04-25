package com.example.CartOrder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.CartOrder.dto.CartOrdJoinDTO;
import com.example.CartOrder.dto.DeliveryInfoDTO;
import com.example.CartOrder.dto.OrderDoneDTO;
import com.example.CartOrder.dto.OrderInfoDTO;
import com.example.CartOrder.dto.OrderSearchDTO;
import com.example.CartOrder.dto.OrderSearchPagingDTO;
import com.example.CartOrder.service.OrderService;
import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;

import io.swagger.annotations.ApiOperation;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@ApiOperation(value = "fastOrderConfirm")
	@ResponseBody
	@PostMapping(value = { "/check/orderConfirm/{itCd}/{amount}/optCd/{optCd}",
			"/check/orderConfirm/{itCd}/{amount}/optCd" })
	public ComResponseEntity<List<CartOrdJoinDTO>> fastOrderConfirm(@PathVariable("itCd") Integer itCd,
			@PathVariable("amount") Integer amount, @PathVariable(name = "optCd", required = false) Integer optCd) {
		String mbId = SessionAttributeManager.getMemberId();
		CartOrdJoinDTO cartOrdJoinDTO = new CartOrdJoinDTO();
		cartOrdJoinDTO.setItCd(itCd);
		cartOrdJoinDTO.setAmount(amount);
		cartOrdJoinDTO.setOptCd(optCd);
		cartOrdJoinDTO.setMbId(mbId);
		Integer addCart = orderService.fastOrderConfirm(cartOrdJoinDTO);
		List<CartOrdJoinDTO> itemJoinList = orderService.cartOrdJoin(cartOrdJoinDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("주문상품 정보", itemJoinList));
	}

	// 주문하기
	@ApiOperation(value = "orderConfirm")
	@ResponseBody
	@GetMapping("/check/orderConfirm")
	public ComResponseEntity<List<CartOrdJoinDTO>> orderConfirm(@RequestParam("cartCd") List<Integer> cartCds) {
		String mbId = SessionAttributeManager.getMemberId();
		CartOrdJoinDTO cartOrdJoinDTO = new CartOrdJoinDTO();
		List<CartOrdJoinDTO> itemJoinLists = new ArrayList<CartOrdJoinDTO>();

		for (Integer cartCd : cartCds) {
			cartOrdJoinDTO.setCartCd(cartCd);
			List<CartOrdJoinDTO> itemJoinList = orderService.cartOrdJoin(cartOrdJoinDTO);
			itemJoinLists.addAll(itemJoinList);
		}
		return new ComResponseEntity<>(new ComResponseDTO<>("주문상품 정보", itemJoinLists));

	}

//   //주문완료
	@ApiOperation(value = "orderDone")
	@ResponseBody
	@PostMapping("/check/orderDone")
	public ComResponseEntity<List<OrderDoneDTO>> orderDone(@RequestParam("cartCd") List<Integer> cartCd,
			@RequestBody OrderInfoDTO orderInfoDTO) {
		List<OrderDoneDTO> cartOrdDTO = orderService.orderDone(cartCd, orderInfoDTO);
		System.err.println(cartOrdDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("주문완료", cartOrdDTO));
	}

	@GetMapping("/check/orderSearch")
	@ResponseBody
	@ApiOperation(value = "orderSearch")
	public ComResponseEntity<OrderSearchPagingDTO> orderSearch(
			@RequestParam(value = "curPage", required = false, defaultValue = "1") Integer curPage) {
		OrderSearchPagingDTO orderSearchPagingDTO = new OrderSearchPagingDTO();
		OrderSearchDTO orderSearchDTO = new OrderSearchDTO();

		setPaging(orderSearchPagingDTO, orderSearchDTO, curPage);
		List<OrderSearchDTO> orderSearchList = orderService.orderSearch(orderSearchDTO);
		orderSearchPagingDTO.setList(orderSearchList);
		System.err.println(orderSearchPagingDTO);

		return new ComResponseEntity<>(new ComResponseDTO<>("주문내역 상품", orderSearchPagingDTO));
	}

	@GetMapping("/check/orderSearch/{startDay}/{endDay}/{itNm}")
	@ResponseBody
	@ApiOperation(value = "daySearch")
	public ComResponseEntity<OrderSearchPagingDTO> daySearch(
			@RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
			@PathVariable(name = "itNm", required = false) String itNm, @PathVariable("startDay") String startDay,
			@PathVariable("endDay") String endDay) {
		OrderSearchPagingDTO orderSearchPagingDTO = new OrderSearchPagingDTO();
		OrderSearchDTO orderSearchDTO = new OrderSearchDTO();
		setPaging(orderSearchPagingDTO, orderSearchDTO, curPage);
		orderSearchDTO.setItNm(itNm);
		orderSearchDTO.setStartDay(startDay);
		orderSearchDTO.setEndDay(endDay);
		List<OrderSearchDTO> itemSearchList = orderService.daySearch(orderSearchDTO);
		orderSearchPagingDTO.setList(itemSearchList);
		return new ComResponseEntity<>(new ComResponseDTO<>("주문내역 조회", orderSearchPagingDTO));
	}

	@GetMapping("/check/dlvyState/{dlvyCd}")
	@ResponseBody
	@ApiOperation(value = "dlvyState")
	private ComResponseEntity<List<DeliveryInfoDTO>> dlvyState(@PathVariable("dlvyCd") Integer dlvyCd) {
		List<DeliveryInfoDTO> deliveryInfoList = orderService.dlvyState(dlvyCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("배송정보", deliveryInfoList));
	}

	private void setPaging(OrderSearchPagingDTO orderSearchPagingDTO, OrderSearchDTO orderSearchDTO, Integer curPage) {
		String mbId = SessionAttributeManager.getMemberId();
		Integer perPage = orderSearchPagingDTO.getPerPage();
	    Integer totalCount = orderService.totalCount(mbId);
	    Integer totalPage = (int) Math.ceil(totalCount / perPage);
	    Integer startIdx = (curPage - 1) * perPage;
	    Integer endIdx = perPage * curPage - 1;
	    orderSearchDTO.setMbId(mbId);
	    orderSearchDTO.setStartIdx(startIdx);
	    orderSearchDTO.setEndIdx(endIdx);
	    orderSearchPagingDTO.setCurPage(curPage);
	    orderSearchPagingDTO.setTotalPage(totalPage);
	}
}