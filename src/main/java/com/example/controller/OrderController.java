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

import com.example.dto.CartDTO;
import com.example.dto.MemberDTO;
import com.example.dto.OrderHistoryDTO;
import com.example.dto.OrderHistoryPageDTO;
import com.example.dto.OrderInfoDTO;
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
	@PostMapping("/loginCheck/orderConfirm/")
	public ModelAndView orderConfirm
	(@RequestBody List<CartDTO> carts, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberInfo");
		Integer confirm = 0;
		for (CartDTO cart : carts) {
			cart.setMbId(memberDTO.getMbId());
			confirm += cartService.cartAdd(cart);
		}
		System.out.println("총 주문 갯수는 " + confirm + " 개 입니다.");
		//ModelAndView mav = new ModelAndView("orderItem");
		//위 코드처럼 작성하면 알아서 orderItem.html을 찾아갑니다.
		ModelAndView mav = new ModelAndView();
		//학원에서 사용한 일반적인 코드입니다.
		mav.addObject("member_cd", memberDTO.getMbId());
		mav.addObject("carts", carts);
		mav.setViewName("orderConfirm");
		return mav;
	}
	
	//ppt 7 page 결제하기 버튼 누른 후
	//ppt 8 page 주문결제 완료 화면으로 넘어갑니다.
	@PostMapping("/loginCheck/orderDone")
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
	
	private HashMap<String, String> searchPaging(Integer curPage, HttpSession session) {
		//여기서 path은자제해야합니다.
		//curPage는 cuurentPage에 약자로 현재 페이지입니다.
		//perPage는 페이지 당 입니다. 페이지 당 게시글 숫자입니다.
	   MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberInfo");
	   //로그인정보
	   String memberCD = memberDTO.getMbId();
	   //아이디 끌어오기
	   Integer totalCount = orderService.totalCount(memberCD);
	   //게시글 전체 갯수
	   Integer perPage = orderSearchPage.getPerPage(); 
	   Integer totalPage = (int)Math.ceil(totalCount / perPage);
	   //올림함수 앞에 int or double 필수 저번에 perPage에 +1 값을 했는데 올바른 값이 안나올수도 있다고 해서 변경한다.
	   //(total_count / perPage)+1  이전에 만든 코드...
	   if (curPage==0) {curPage=1;}
	   Integer startIdx = (curPage-1) * perPage+1;
	   HashMap<String, String> map = new HashMap<String, String>();
	   map.put("memberCd", memberCD);
	   map.put("perPage", Integer.toString(perPage));
	   map.put("startIdx", Integer.toString(startIdx));
		return map;
	}
	
	//상품 주문내역 조회입니다.
	//기본 페이지입니다.
	//ppt page 11번입니다.
	@GetMapping("/loginCheck/orderSearch/")
	@ResponseBody
	@ApiOperation(value = "orderSearch")
	public List<OrderHistoryDTO> orderSearch
	(@RequestParam(value = "curPage", required = false, defaultValue = "1") Integer curPage, HttpSession session) {
		HashMap<String, String> map = searchPaging(curPage, session);
	   List<OrderHistoryDTO> list = orderService.orderSearch(map);
	   return list;
	}


	
		//상품 주문내역 조회입니다.
		//날짜 버튼 눌렀을 떄 조회입니다.
		//ppt page 11번입니다.
		@GetMapping("/loginCheck/orderSearch/{startDay}/{endDay}")
		@ResponseBody
		@ApiOperation(value = "daySearch")
		public List<OrderHistoryDTO> daySearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1") 
		int curPage, @PathVariable("startDay") String startDay, 
		@PathVariable("endDay")String endDay, HttpSession session) {
		   HashMap<String, String> map = searchPaging(curPage, session);
		   map.put("startDay", startDay);
		   map.put("endDay", endDay);
		   //맵으로 넣으면 안됩니다.
		   //왜냐하면 맵으로 넣으면 에러가 생겨서 찾을 때 찾기가 어렵기 때문입니다.
		   //그런데 이부분은 꼭 맵으로 처리해서 에러를 만들겁니다.
		   List<OrderHistoryDTO> list = orderService.daySearch(map);
		   return list;
		}
		// 직접 item_nm을 입력해서 
		@GetMapping("/loginCheck/orderSearch/{itemNm}")
		@ResponseBody
		@ApiOperation(value = "itemSearch")
		public List<OrderHistoryDTO> itemSearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1") 
		int curPage, @PathVariable("itemNm") String itemNm, HttpSession session) {
		   HashMap<String, String> map = searchPaging(curPage, session);
		   map.put("itemCd", itemNm);
		   List<OrderHistoryDTO> list = orderService.itemSearch(map);
		   return list;
		}
	
}