package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.example.dto.OrderHistoryDTO;
import com.example.dto.OrderHistoryPageDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;
import com.example.service.CartService;
import com.example.service.MemberService;
import com.example.service.OrderService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.swagger.annotations.ApiOperation;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	MemberService memberService;
	@Autowired
	CartService cartService;
	@Autowired
	SessionAttributeManager memberInfo;
	OrderHistoryPageDTO orderSearchPage;
	//현재 주문내역 조회는 날짜조회,아이템 조회만 있습니다.
	//날짜 조회+아이템 조회는 고려중입니다.
	//체크 박스로 체크해서 같이 넘길지 무언가 그냥 넘길지 고민 중입니다.
	//또한 중복 코드가 많습니다. 이렇게 받아야하는지 고민입니다.
	//10.31 11.17 일단 끝

	//주문결제화면
	//상품자세히보기 화면 찜화면 장바구니화면에서 넘어옵니다.
	//ppt 6page orderConfirm.html로 이동됩니다.
	//또는 9page에서 일어나는 이벤트
	//구매하기 버튼 누를 때입니다.
	//modleandview->entity로 변환 해줘야함
	//order 숫자 확인도 해야함
	@ApiOperation(value = "orderConfirm")
	@PostMapping("/check/orderConfirm/")
	public ModelAndView orderConfirm
	(@RequestBody List<CartDTO> carts) {
		String mbId=memberInfo.getMemberId();
		Integer confirm = 0;
		for (CartDTO cart : carts) {
			cart.setMbId(mbId);
			confirm = confirm + cartService.cartAdd(cart);
		}
		System.out.println("총 주문 갯수는 " + confirm + " 개 입니다.");
		//ModelAndView mav = new ModelAndView("orderItem");
		//위 코드처럼 작성하면 알아서 orderItem.html을 찾아갑니다.
		ModelAndView mav = new ModelAndView();
		//학원에서 사용한 일반적인 코드입니다.
		mav.addObject("member_cd", mbId);
		mav.addObject("carts", carts);
		mav.setViewName("orderConfirm");
		return mav;
	}
	
	//ppt 7 page 결제하기 버튼 누른 후
	//ppt 8 page 주문결제 완료 화면으로 넘어갑니다.
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
	  
	   String mbId = memberInfo.getMemberId();
	   Integer totalCount = orderService.totalCount(mbId);
	   Integer perPage = orderSearchPage.getPerPage();
//	   페이지당.10개야.
	   Integer totalPage = (int)Math.ceil(totalCount / perPage);
	   if (curPage==0) {curPage=1;}
	   Integer startIdx = (curPage-1) * perPage+1;
	   Integer endIdx = perPage*startIdx;
	   OrderSearchDTO orderSearchDTO= new OrderSearchDTO();
	   orderSearchDTO.setMbId(mbId);
	   orderSearchDTO.setPerPage(Integer.toString(perPage));
	   orderSearchDTO.setStartIdx(Integer.toString(startIdx));
	   orderSearchDTO.setEndIdx(Integer.toString(startIdx));
	   return orderSearchDTO;
	}
	
	//상품 주문내역 조회입니다.
	//기본 페이지입니다.
	//ppt page 11번입니다.
	@GetMapping("/check/orderSearch/")
	@ResponseBody
	@ApiOperation(value = "orderSearch")
	public List<OrderSearchDTO> orderSearch
	(@RequestParam(value = "curPage", required = false, defaultValue = "1") Integer curPage) {
		OrderSearchDTO orderSearchDTO = searchPaging(curPage); 
		List<OrderSearchDTO> orderSearchList = orderService.orderSearch(orderSearchDTO);
	   return orderSearchList;
	}


	
		//상품 주문내역 조회입니다.
		//날짜 버튼 눌렀을 떄 조회입니다.
		//ppt page 11번입니다.
		@GetMapping("/check/orderSearch/{startDay}/{endDay}")
		@ResponseBody
		@ApiOperation(value = "daySearch")
		public List<OrderSearchDTO> daySearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1") 
		int curPage, @PathVariable("startDay") String startDay, @PathVariable("endDay")String endDay) {
			OrderSearchDTO orderSearchDTO = searchPaging(curPage); 
			orderSearchDTO.setStartDay(startDay);
			orderSearchDTO.setEndDay(endDay);
			List<OrderSearchDTO> daySearchList = orderService.daySearch(orderSearchDTO);
		   return daySearchList;
		}
		
		// 직접 item_nm을 입력해서 
		@GetMapping("/check/orderSearch/{itemNm}")
		@ResponseBody
		@ApiOperation(value = "itemSearch")
		public List<OrderSearchDTO> itemSearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1") 
		int curPage, @PathVariable("itemNm") String itemNm) {
			OrderSearchDTO orderSearchDTO = searchPaging(curPage); 
			orderSearchDTO.setItNm(itemNm);
		   List<OrderSearchDTO> itemSearchList = orderService.itemSearch(orderSearchDTO);
		   return itemSearchList;
		}
	
}
