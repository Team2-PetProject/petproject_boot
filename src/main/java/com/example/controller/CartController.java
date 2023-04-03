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

import io.swagger.annotations.ApiOperation;
@Controller
public class CartController {
	@Autowired
	MemberService memberService;
	@Autowired
	CartService cartService;
	
	
	
//	//5에서 일어나는 이벤트
//	//장바구니 추가 //restful 미적용
//	@PostMapping("/loginCheck/cartAdd")
//	public String cartAdd
//	(@RequestParam CartDTO cart, HttpSession session) {
//	    MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberInfo");
//	    cart.setMember_Code(memberDTO.getMember_code());
//	    Integer insertCart = cartService.cartAdd(cart);
//	    return "redirect:/itemRetrieve?item_code=" + cart.getItem_Code();
//	}
	
	
	@PostMapping("/loginCheck/cartAdd")
	@ResponseBody
	@ApiOperation(value = "cartAdd")
	public ResponseEntity<Map<String, Object>> CartAdd(CartDTO cart, HttpSession session){
		 MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		 cart.setMbId(memberDTO.getMbId());
		 Integer AddItem = cartService.cartAdd(cart);
		 Map<String, Object> cartAdd = new HashMap<String, Object>();
		 cartAdd.put("success", AddItem > 0);
		 cartAdd.put("item_cd", cart.getCartCd());
		 return ResponseEntity.ok(cartAdd);
	}
    
	
	//9에서 일어나는 이벤트
	//한개 삭제
	@DeleteMapping("/loginCheck/cartDelete/{cart_cd}")
	@ResponseBody
	@ApiOperation(value = "cartDelete")
	public void cartDelete
	(@PathVariable int cartCD) {
		//cart_cd로 바로 삭제
		Integer deleteOne = cartService.cartDelete(cartCD);
	System.out.println("하나 삭제된 갯수 : "+ deleteOne);
	
	}
	
	//9에서 일어나는 이벤트
	//전체 삭제
	@DeleteMapping("/loginCheck/checkDelete")
	@ResponseBody
	@ApiOperation(value = "checkDelete")
	public void checkDelete
	(@RequestParam("cartCD") List<Integer>list) {
		//cart_cd 리스트 받아서 한번에 삭제
		System.out.println(list);
		Integer allDelete = cartService.checkDelete(list);
		System.out.println("전체 삭제  : " + allDelete);
	} 
	
	//9에서 일어나는 이벤트
	//상품 옵션 변경
	@PutMapping("/logunCheck/specUpdate/{cartCd}/{itemCd}")
	@ResponseBody
	@ApiOperation(value = "specUpdate")
	public int specUpdate
	(@PathVariable("cartCd") int cartCd, @PathVariable("itemCd") int itemCd)
	{
		//CartDTO 바로 사용하용하세요.
		//반환 값은 0 또는 1만 나옵니다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("cartCd", cartCd);
		map.put("itemCd", itemCd);
		return cartService.specUpdate(map);
	}
	
	//9에서 일어나는 이벤트
	//수량 변경
	@PutMapping("/logunCheck/specUpdate/{cartCd}/{itemAmount}")
	@ResponseBody
	@ApiOperation(value = "amountUpdate")
	public int amountUpdate
	(@PathVariable("cartCd") int cartCd, @PathVariable("itemAmount") int itemAmount)
	{
		//CartDTO 바로 사용하용하세요.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("cartCd",cartCd);
		map.put("itemamount",itemAmount);
		return cartService.amountUpdate(map);
	}
}
