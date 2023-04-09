package com.example.controller;

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

import com.example.common.SessionAttributeManager;
import com.example.dto.CartDTO;
import com.example.dto.MemberDTO;
import com.example.dto.OrderHistoryPageDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;
import com.example.dto.SearchResultDTO;
import com.example.service.CartService;
import com.example.service.MemberService;
import com.example.service.OrderService;

import io.swagger.annotations.ApiOperation;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	MemberService memberService;
	@Autowired
	CartService cartService;

	OrderHistoryPageDTO orderSearchPage;

	@ApiOperation(value = "orderConfirm")
	@PostMapping("/check/orderConfirm/")
	public ModelAndView orderConfirm
	(@RequestBody List<CartDTO> carts) {
		String mbId=SessionAttributeManager.getMemberId();
		Integer confirm = 0;
		for (CartDTO cart : carts) {
			cart.setMbId(mbId);
			confirm = confirm + cartService.cartAdd(cart);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("mbId", mbId);
		mav.addObject("carts", carts);
		mav.setViewName("orderConfirm");
		return mav;
	}

	@PostMapping("/check/orderDone")
	@ApiOperation(value = "orderDone")
	public ModelAndView orderDone
	(@RequestBody List<CartDTO> carts, @RequestBody OrderInfoDTO info, HttpSession session) {
	    MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberInfo");
	    String memberCD = memberDTO.getMbId();
	    orderService.orderDone(carts, info, memberCD);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("carts", carts);
	    mav.addObject("info", info);
		mav.addObject("memberCD", memberDTO.getMbId());
		mav.setViewName("orderDone");
	    return mav;
	}

	//  이 함수는 중복 코드 부분을 빼서 만들었습니다.
	//  이 때 필요한 것들이 있습니다.
	//  경고 창을 보고 밑에 변수들을 잘 보고 처리해주면 쉽게 해결됩니다.

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
