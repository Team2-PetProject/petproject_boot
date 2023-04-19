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
import com.example.CartOrder.dto.OrderHistoryPageDTO;
import com.example.CartOrder.dto.OrderInfoDTO;
import com.example.CartOrder.dto.OrderSearchDTO;
import com.example.CartOrder.service.OrderService;
import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;

import io.swagger.annotations.ApiOperation;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	OrderHistoryPageDTO orderSearchPage;
	@ApiOperation(value = "fastOrderConfirm")
	@ResponseBody
	@PostMapping("/check/orderConfirm/{itCd}/{amount}/{optCd}")
	public ComResponseEntity<List<CartOrdJoinDTO>> fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO){
		String mbId=SessionAttributeManager.getMemberId();
		cartOrdJoinDTO.setMbId(mbId);
		Integer addCart = orderService.fastOrderConfirm(cartOrdJoinDTO);
		List<CartOrdJoinDTO>itemJoinList = orderService.cartOrdJoin(cartOrdJoinDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("주문상품 정보", itemJoinList));
	}


	//주문하기
	@ApiOperation(value = "orderConfirm")
	//@ResponseBody
	@GetMapping("/check/orderConfirm")
	public ComResponseEntity<List<CartOrdJoinDTO>> orderConfirm(@RequestParam("cartCd") List<Integer> cartCds) {
		String mbId=SessionAttributeManager.getMemberId();
		CartOrdJoinDTO cartOrdJoinDTO = new CartOrdJoinDTO();
		List<CartOrdJoinDTO> itemJoinLists = new ArrayList<CartOrdJoinDTO>();

		for (Integer cartCd : cartCds) {
		cartOrdJoinDTO.setCartCd(cartCd);
		List<CartOrdJoinDTO> itemJoinList = orderService.cartOrdJoin(cartOrdJoinDTO);
		itemJoinLists.addAll(itemJoinList);
		}
		return new ComResponseEntity<>(new ComResponseDTO<>("주문상품 정보", itemJoinLists));
		
	}


//	//주문완료
	@ApiOperation(value = "orderDone")
	@ResponseBody
	@PostMapping("/check/orderDone")
	public ComResponseEntity<List<OrderDoneDTO>> orderDone
	(@RequestParam("cartCd") List<Integer> cartCd, @RequestBody OrderInfoDTO orderInfoDTO) {
		List<OrderDoneDTO> cartOrdDTO = orderService.orderDone(cartCd,orderInfoDTO);
		System.err.println(cartOrdDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("주문완료", cartOrdDTO));
	}



	@GetMapping("/check/orderSearch/")
	@ResponseBody
	@ApiOperation(value = "orderSearch")
	public ComResponseEntity<List<OrderSearchDTO>> orderSearch
	(@RequestParam(value = "curPage", required = false, defaultValue = "1") Integer curPage) {
		OrderSearchDTO orderSearchDTO = searchPaging(curPage);
		List<OrderSearchDTO> orderSearchList = orderService.orderSearch(orderSearchDTO);
		System.err.println(orderSearchList);
	   return new ComResponseEntity<>(new ComResponseDTO<>("주문내역 상품", orderSearchList));
	}


		@GetMapping("/check/orderSearch/{startDay}/{endDay}/{itNm}")
		@ResponseBody
		@ApiOperation(value = "daySearch")
		public ComResponseEntity<List<OrderSearchDTO>> daySearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1")
		int curPage,
		@PathVariable(name = "itNm", required = false) String itNm,
		@PathVariable("startDay") String startDay,
		@PathVariable("endDay")String endDay) {

			OrderSearchDTO orderSearchDTO = extracted(curPage, startDay, endDay);
			orderSearchDTO.setItNm(itNm);
		   List<OrderSearchDTO> itemSearchList = orderService.daySearch(orderSearchDTO);
		   return new ComResponseEntity<>(new ComResponseDTO<>("주문내역 조회", itemSearchList));
		}

		@GetMapping("/check/dlvyState/{dlvyCd}")
		@ResponseBody
		@ApiOperation(value = "dlvyState")
		private ComResponseEntity<List<DeliveryInfoDTO>> dlvyState (@PathVariable("dlvyCd") Integer dlvyCd) {
			System.out.println("ddd");
			List<DeliveryInfoDTO> deliveryInfoList =orderService.dlvyState(dlvyCd);
			return new ComResponseEntity<>(new ComResponseDTO<>("배송정보", deliveryInfoList));
		}

		private OrderSearchDTO extracted(int curPage, String startDay, String endDay) {
			OrderSearchDTO orderSearchDTO = searchPaging(curPage);
			orderSearchDTO.setStartDay(startDay);
			orderSearchDTO.setEndDay(endDay);
			return orderSearchDTO;
		}

		private OrderSearchDTO searchPaging(@PathVariable("curPage")Integer curPage) {
			orderSearchPage = new OrderHistoryPageDTO();
		   String mbId = SessionAttributeManager.getMemberId();
		   Integer totalCount = orderService.totalCount(mbId);
		   Integer perPage = orderSearchPage.getPerPage();
		   Integer totalPage = (int)Math.ceil(totalCount / perPage);
		   Integer startIdx = (curPage-1) * perPage;
		   Integer endIdx = perPage*curPage-1;
		   OrderSearchDTO orderSearchDTO= new OrderSearchDTO();
		   orderSearchDTO.setMbId(mbId);
		   orderSearchDTO.setPerPage(perPage);
		   orderSearchDTO.setStartIdx(startIdx);
		   orderSearchDTO.setEndIdx(startIdx);
		   orderSearchDTO.setEndIdx(endIdx);
		   System.err.println(orderSearchDTO);
		   return orderSearchDTO;
		}

}