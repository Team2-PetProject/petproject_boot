package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ItemFavoriteDTO;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import com.example.service.item_FavoriteService;
@Controller
public class FavoriteController {
	@Autowired
	MemberService m_service;
	@Autowired
	item_FavoriteService i_service;
	//다시 상품 상세보기로 돌려야함
	
	@PostMapping("/loginCheck/favoriteAdd") 
	public String favoriteAdd
	(@RequestParam("item_code") int item_code, HttpSession session) {
		MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
		ItemFavoriteDTO i_dto = new ItemFavoriteDTO();
		i_dto.setMember_Code(m_dto.getMember_code());
		i_dto.setItem_Code(item_code);
		int n = i_service.favoriteAdd(i_dto);
		System.out.println("favoriteAdd : " + n);
		return "redirect:/itemRetrieve?item_code=" + item_code;
	}
}
