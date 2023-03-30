package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.CartDTO;
import com.example.dto.MemberDTO;
import com.example.service.CartService;
import com.example.service.ItemService;
import com.example.service.MemberService;
@Controller
public class CartController {
	@Autowired
	MemberService m_service;
	@Autowired
	CartService c_service;
	
	
	@PostMapping("/loginCheck/cartAdd")
	public String cartAdd
	(CartDTO cart, HttpSession session) {
	    MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
	    cart.setMember_Code(m_dto.getMember_code());
	    int num = c_service.cartAdd(cart);
	    return "redirect:/itemRetrieve?item_code=" + cart.getItem_Code();
	}
	
	@DeleteMapping("/loginCheck/cartDelete")
	@ResponseBody
	public void cartDelete
	(@RequestParam("cart_cd")int cart_cd) {
		int num = c_service.cartDelete(cart_cd);
		System.out.println("삭제 갯수 : " + num);
	}
	
	@DeleteMapping("/loginCheck/checkDelete")
	@ResponseBody
	public void checkDelete
	(@RequestParam("cart_cd") List<Integer>list) {
		System.out.println(list);
		int num = c_service.checkDelete();
	}
	
	@PutMapping("/logunCheck/cartUpdate")
	@ResponseBody
	public void cartUpdate
	()
	{
		
	}
}
