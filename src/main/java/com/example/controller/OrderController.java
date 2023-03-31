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

@Controller
public class OrderController {

	@Autowired
	OrderService o_service;
	@Autowired
	MemberService m_service;
	@Autowired
	CartService c_service;
	
	OrderHistoryPageDTO page;
	//현재 주문내역 조회는 날짜조회,아이템 조회만 있습니다.
	//날짜 조회+아이템 조회는 고려중입니다.
	//체크 박스로 체크해서 같이 넘길지 무언가 그냥 넘길지 고민 중입니다.

	//주문결제화면
	//상품자세히보기 화면 찜화면 장바구니화면에서 넘어옵니다.
	//ppt 6page orderConfirm.html로 이동됩니다.
	//또는 9page에서 일어나는 이벤트
	//구매하기 버튼 누를 때입니다.
	@PostMapping("/loginCheck/orderConfirm/")
	public ModelAndView orderConfirm
	(@RequestBody List<CartDTO> carts, HttpSession session) {
		MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
		int num = 0;
		for (CartDTO cart : carts) {
			cart.setMember_Code(m_dto.getMember_code());
			num += c_service.cartAdd(cart);
		}
		System.out.println("총 주문 갯수는 " + num + " 개 입니다.");
		//ModelAndView mav = new ModelAndView("orderItem");
		//위 코드처럼 작성하면 알아서 orderItem.html을 찾아갑니다.
		ModelAndView mav = new ModelAndView();
		//학원에서 사용한 일반적인 코드입니다.
		mav.addObject("member_cd", m_dto.getMember_code());
		mav.addObject("carts", carts);
		mav.setViewName("orderConfirm");
		return mav;
	}
	
	//ppt 7 page 결제하기 버튼 누른 후
	//ppt 8 page 주문결제 완료 화면으로 넘어갑니다.
	@PostMapping("/loginCheck/orderDone")
	public ModelAndView orderDone
	(@RequestBody List<CartDTO> carts, @RequestBody OrderInfoDTO info, HttpSession session) {
	    MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
	    String member_cd = m_dto.getMember_code();
	    o_service.orderDone(carts, info, member_cd);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("carts", carts);
	    mav.addObject("info", info);
		mav.addObject("member_cd", m_dto.getMember_code());
		mav.setViewName("orderDone");
	    return mav;
	}
	
	//상품 주문내역 조회입니다.
	//기본 페이지입니다.
	//ppt page 11번입니다.
	@GetMapping("/loginCheck/orderSearch/")
	@ResponseBody
	public List<OrderHistoryDTO> orderSearch
	(@RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage, HttpSession session) {
		//여기서 path은자제해야합니다.
		//curPage는 cuurentPage에 약자로 현재 페이지입니다.
		//perPage는 페이지 당 입니다. 페이지 당 게시글 숫자입니다.
	   MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
	   //로그인정보
	   String member_cd = m_dto.getMember_code();
	   //아이디 끌어오기
	   int total_count = o_service.totalCount(member_cd);
	   //게시글 전체 갯수
	   int perPage = page.getPerPage(); 
	   int total_page = (int)Math.ceil(total_count / perPage);
	   //올림함수 앞에 int 필수 저번에 perPage에 +1 값을 했는데 올바른 값이 안나올수도 있다고 한다.
	   //(total_count / perPage)+1 사칙연산 헷갈리는 분을 위해서...
	   if (curPage==0) {curPage=1;}
	   int startIdx = (curPage-1) * perPage+1;
	   HashMap<String, String> map = new HashMap<String, String>();
	   map.put("member_cd", member_cd);
	   map.put("perPage", Integer.toString(perPage));
	   map.put("", Integer.toString(startIdx));
	   List<OrderHistoryDTO> list = o_service.orderSearch(map);
	   return list;
	}
	
		//상품 주문내역 조회입니다.
		//날짜 조회입니다.
		//ppt page 11번입니다.
		@GetMapping("/loginCheck/orderSearch/startDay/{startDay}/endDay/{endDay}")
		@ResponseBody
		public List<OrderHistoryDTO> daySearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1") 
		int curPage, @PathVariable("startDay") String startDay, 
		@PathVariable("endDay")String endDay, HttpSession session) {
		   MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
		   String member_cd = m_dto.getMember_code();
		   int total_count = o_service.totalCount(member_cd);
		   int perPage = page.getPerPage(); 
		   int total_page = (int)Math.ceil(total_count / perPage);
		   if (curPage==0) {curPage=1;}
		   int startIdx = (curPage-1) * perPage+1;
		   HashMap<String, String> map = new HashMap<String, String>();
		   map.put("member_cd", member_cd);
		   map.put("perPage", Integer.toString(perPage));
		   map.put("startIdx", Integer.toString(startIdx));
		   map.put("startDay", startDay);
		   map.put("endDay", endDay);
		   List<OrderHistoryDTO> list = o_service.daySearch(map);
		   return list;
		}
	
		@GetMapping("/loginCheck/orderSearch/item_cd/{item_cd}")
		@ResponseBody
		public List<OrderHistoryDTO> itemSearch
		(@RequestParam(value = "curPage", required = false, defaultValue = "1") 
		int curPage, @PathVariable("item_cd") String item_cd, HttpSession session) {
		   MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
		   String member_cd = m_dto.getMember_code();
		   int total_count = o_service.totalCount(member_cd);
		   int perPage = page.getPerPage(); 
		   int total_page = (int)Math.ceil(total_count / perPage);
		   if (curPage==0) {curPage=1;}
		   int startIdx = (curPage-1) * perPage+1;
		   HashMap<String, String> map = new HashMap<String, String>();
		   map.put("member_cd", member_cd);
		   map.put("perPage", Integer.toString(perPage));
		   map.put("startIdx", Integer.toString(startIdx));
		   map.put("item_cd", item_cd);
		   List<OrderHistoryDTO> list = o_service.itemSearch(map);
		   return list;
		}
	
}
