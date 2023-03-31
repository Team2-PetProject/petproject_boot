package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.ItemFavoriteDTO;
import com.example.dto.MemberDTO;
import com.example.service.ItemService;
import com.example.service.MemberService;
@Controller
public class FavoriteController {
	@Autowired
	MemberService m_service;
	@Autowired
	ItemService i_service;
	//다시 상품 상세보기로 돌려야함
	//찜목록 추가 restful로 변경필요 //
	//03.31 오늘은 건들지 말자.
	//11시 50분
	//sys 추후 삭제
	
	
	//상세페이지에서 찜 버튼을 눌러도 그대로 그 상품페이지다.
	@PostMapping("/loginCheck/favorite/item_cd/{item_cd}")
	@ResponseBody
	public void favoriteAdd
	(@PathVariable("item_cd") int item_cd, HttpSession session) {
		MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
		ItemFavoriteDTO i_dto = new ItemFavoriteDTO();
		i_dto.setMember_Code(m_dto.getMember_code());
		i_dto.setItem_Code(item_cd);
		int n = i_service.favoriteAdd(i_dto);
		System.out.println("favoriteAdd : " + n);
	}
	
	@DeleteMapping("/loginCheck/favorite/item_cd/{item_cd}")
	@ResponseBody
	public void favoriteDelete
	(@PathVariable("item_cd") int item_cd, HttpSession session) {
		MemberDTO m_dto = (MemberDTO) session.getAttribute("login");
		String member_cd= m_dto.getMember_code();
		ItemFavoriteDTO i_dto = new ItemFavoriteDTO();
		int num = i_service.favoriteDelete(member_cd,item_cd);
		System.out.println("해당 "+ num +" 번호 가 삭제되었습니다");
	}
}
