package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.CartDTO;
import com.example.dto.ItemDTO;
import com.example.dto.ItemFavoriteDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.MemberDTO;
import com.example.service.ItemService;
import com.example.service.MemberService;

// 상품리스트
// 상품상세보기


@Controller
public class ItemController {
	@Autowired
	ItemService i_service;
	@Autowired
	MemberService m_service;
	
	//내 부분 아니고 성혁이 부분 그리고 restful 미적용
	//4
	@GetMapping("/itemList") //단순 조회는 get
	public String itemList
	(@RequestParam(value = "item_cat", defaultValue = "food") 
	//path에서 안되는데 굳이 써야할까...
	String item_cat, Model model) {
	    List<ItemListDTO> list = i_service.itemList(item_cat);
	    System.out.println("itemList: " + list);
	    model.addAttribute("itemList", list);
	    return "main";
	}

	@GetMapping("/itemRetrieve") //단순 조회 부분
	public String itemRetrieve
	(@RequestParam("item_code") String item_cd, Model model) {
	    ItemDTO i_dto = i_service.detail(item_cd);
	    System.out.println("상품상세보기 : " + i_dto);
	    model.addAttribute("itemDTO", i_dto);
	    return "itemRetrieve";
	}
	
	
	


}
