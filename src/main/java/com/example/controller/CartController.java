package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.CartDTO;
import com.example.dto.MemberDTO;
import com.example.service.CartService;
import com.example.service.MemberService;
@Controller
public class CartController {
	@Autowired
	MemberService m_service;
	@Autowired
	CartService c_service;
	
	
	//장바구니 추가
	@PostMapping("/loginCheck/cartAdd")
	public String cartAdd
	(@RequestParam CartDTO cart, HttpSession session) {
	    MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
	    cart.setMember_Code(m_dto.getMember_code());
	    int num = c_service.cartAdd(cart);
	    return "redirect:/itemRetrieve?item_code=" + cart.getItem_Code();
	}
	
	
//	@PostMapping("/loginCheck/cartAdd")
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> CartAdd2(CartDTO cart, HttpSession session){
//		 MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
//		 cart.setMember_Code(m_dto.getMember_code());
//		 int num = c_service.cartAdd(cart);
//		 Map<String, Object> cartAdd = new HashMap<String, Object>();
//		 cartAdd.put("success", num > 0);
//		 cartAdd.put("item_cd", cart.getCart_Code());
//		 return ResponseEntity.ok(cartAdd);
//		 //저도 그냥 받아적었습니다. 이해 못했습니다.
//	}
    
	
	
	//한개 삭제
	@DeleteMapping("/loginCheck/cartDelete/cart_cd/{cart_cd}")
	@ResponseBody
	public void cartDelete
	(@PathVariable int cart_cd) {
		//cart_cd로 바로 삭제
	int n = c_service.cartDelete(cart_cd);
	System.out.println("하나 삭제된 갯수 : "+ n);
	
	}
	
	//전체 삭제
	@DeleteMapping("/loginCheck/checkDelete")
	@ResponseBody
	public void checkDelete
	(@RequestParam("cart_cd") List<Integer>list) {
		//cart_cd 리스트 받아서 한번에 삭제
		System.out.println(list);
		int num = c_service.checkDelete();
		System.out.println("전체 삭제  : " + num);
	} 
	
	//상품 옵션 변경
	@PutMapping("/logunCheck/specUpdate/cart_cd/{cart_cd}/item_cd/{item_cd}")
	@ResponseBody
	public CartDTO specUpdate
	(@PathVariable int cart_cd, @PathVariable int item_cd)
	{
		//CartDTO 바로 사용하용하세요.
		return c_service.specUpdate(cart_cd,item_cd);
	}
	
	//수량 변경
	@PutMapping("/logunCheck/specUpdate/cart_cd/{cart_cd}/amount/{item_amount}")
	@ResponseBody
	public CartDTO amountUpdate
	(@PathVariable int cart_cd, @PathVariable int item_amount)
	{
		//CartDTO 바로 사용하용하세요.
		return c_service.specUpdate(cart_cd,item_amount);
	}
}
