package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.CartDTO;
import com.example.dto.CartOrdDTO;
import com.example.dto.CartOrdJoinDTO;
import com.example.dto.OrderDoneDTO;
import com.example.dto.OrderHistoryPageDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;
import com.example.service.MemberService;
import com.example.service.OrderService;

import io.swagger.annotations.ApiOperation;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	MemberService memberService;

	OrderHistoryPageDTO orderSearchPage;
	//상품자세히-주문결제 화면
	//아이템 조인해서 넘겨줘야함.
	@ApiOperation(value = "fastOrderConfirm")
	@ResponseBody
	@PostMapping("/check/orderConfirm/{itCd}/{amount}/{optCd}")
	public ResponseEntity<List<CartOrdJoinDTO>> fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO){
//		String mbId=SessionAttributeManager.getMemberId();
		String mbId="1";
		cartOrdJoinDTO.setMbId(mbId);
		Integer addCart = orderService.fastOrderConfirm(cartOrdJoinDTO);
		List<CartOrdJoinDTO>itemJoinList = orderService.cartOrdJoin(cartOrdJoinDTO);
		return ResponseEntity.ok(itemJoinList);
	}



	@ApiOperation(value = "orderConfirm")
	@ResponseBody
	@GetMapping("/check/orderConfirm/")
	public ResponseEntity<List<CartOrdJoinDTO>> orderConfirm(@RequestParam("cartCd") List<Integer> cartCds) {
//		String mbId=SessionAttributeManager.getMemberId();
		String mbId="1";
		CartOrdJoinDTO cartOrdJoinDTO = new CartOrdJoinDTO();
		List<CartOrdJoinDTO> itemJoinLists = new ArrayList<CartOrdJoinDTO>();

		for (Integer cartCd : cartCds) {
		cartOrdJoinDTO.setCartCd(cartCd);
		List<CartOrdJoinDTO> itemJoinList = orderService.cartOrdJoin(cartOrdJoinDTO);
		itemJoinLists.addAll(itemJoinList);
		}
		return ResponseEntity.ok(itemJoinLists);
	}


//	//주문완료
	@ApiOperation(value = "orderDone")
	@ResponseBody
	@PostMapping("/check/orderDone")
	public ResponseEntity<List<OrderDoneDTO>> orderDone
	(@RequestParam("cartCd") List<Integer> cartCd, @RequestBody OrderInfoDTO orderInfoDTO) {
		List<OrderDoneDTO> cartOrdDTO = orderService.orderDone(cartCd,orderInfoDTO);
	    return ResponseEntity.ok(cartOrdDTO);
	}


	private OrderSearchDTO searchPaging(@PathVariable("curPage")Integer curPage) {
		orderSearchPage = new OrderHistoryPageDTO();
//	   String mbId = SessionAttributeManager.getMemberId();
//	   Integer totalCount = orderService.totalCount(mbId);
	   String mbId = "1";
	   Integer totalCount = 100;
	   Integer perPage = orderSearchPage.getPerPage();
	   Integer totalPage = (int)Math.ceil(totalCount / perPage);
//	   if (curPage==0) {curPage=1;}

	   curPage=1;
	   Integer startIdx = (curPage-1) * perPage+1;
	   Integer endIdx = perPage*startIdx;
	   OrderSearchDTO orderSearchDTO= new OrderSearchDTO();
	   orderSearchDTO.setMbId(mbId);
	   orderSearchDTO.setPerPage(Integer.toString(perPage));
	   orderSearchDTO.setStartIdx(Integer.toString(startIdx));
	   orderSearchDTO.setEndIdx(Integer.toString(startIdx));
	   return orderSearchDTO;
	}

	@GetMapping("/check/orderSearch/")
	@ResponseBody
	@ApiOperation(value = "orderSearch")
	public ResponseEntity<List<OrderSearchDTO>> orderSearch
	(@RequestParam(value = "curPage", required = false, defaultValue = "1") Integer curPage) {
		OrderSearchDTO orderSearchDTO = searchPaging(curPage);
		List<OrderSearchDTO> orderSearchList = orderService.orderSearch(orderSearchDTO);
	   return ResponseEntity.ok(orderSearchList);
	}



		@GetMapping("/check/orderSearch/{startDay}/{endDay}")
		@ResponseBody
		@ApiOperation(value = "daySearch")
		public ResponseEntity<List<OrderSearchDTO>> daySearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1")
		int curPage, @PathVariable("startDay") String startDay, @PathVariable("endDay")String endDay) {
			OrderSearchDTO orderSearchDTO = searchPaging(curPage);
			orderSearchDTO.setStartDay(startDay);
			orderSearchDTO.setEndDay(endDay);
			List<OrderSearchDTO> daySearchList = orderService.daySearch(orderSearchDTO);
		   return ResponseEntity.ok(daySearchList);
		}

		@GetMapping("/check/orderSearch/{itemNm}")
		@ResponseBody
		@ApiOperation(value = "itemSearch")
		public ResponseEntity<List<OrderSearchDTO>> itemSearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1")
		int curPage, @PathVariable("itemNm") String itemNm) {
			OrderSearchDTO orderSearchDTO = searchPaging(curPage);
			orderSearchDTO.setItNm(itemNm);
		   List<OrderSearchDTO> itemSearchList = orderService.itemSearch(orderSearchDTO);
		   return ResponseEntity.ok(itemSearchList);
		}

}