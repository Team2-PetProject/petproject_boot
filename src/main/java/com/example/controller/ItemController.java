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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.CartDTO;
import com.example.dto.ItemDTO;
//import com.example.dto.ItemFavoriteDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.MemberDTO;
import com.example.service.ItemService;
import com.example.service.MemberService;

// 상품리스트
// 상품상세보기


@Controller
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	MemberService memberService;
	//10시10.
	
	//ppt 4p
//	@GetMapping("/itemList") //단순 조회는 get
//	public String itemList
//	(@RequestParam(value = "itemcat", defaultValue = "food") 
//	String itemcat, Model model) {
//		itemService = new ItemService();
//	    List<ItemListDTO> list = itemService.itemList(itemcat);
//	    System.out.println("itemList: " + list);
//	    model.addAttribute("itemList", list);
//	    return "main";
//	}

//	@GetMapping("/itemRetrieve") //단순 조회 부분
//	public String itemRetrieve
//	(@RequestParam("itemCode") String itemCd, Model model) {
//	    itemService = new ItemService();
//		ItemDTO itemDto = itemService.detail(itemCd);
//	    System.out.println("상품상세보기 : " + itemDto);
//	    model.addAttribute("itemDTO", itemDto);
//	    return "itemRetrieve";
//	}
	
//	@GetMapping("/itemList")
//	@ResponseBody
//	public String itemList
//	(@RequestParam(value = "itemcat", defaultValue = "food")
//	String item_cat) {
//		itemService = new ItemService();
//	    List<ItemListDTO> list = itemService.itemList(item_cat);
//	    System.out.println("itemList: " + list);
//		return "main";
//
//	}
	
	@GetMapping("/itemRetrieve") //단순 조회 부분
	@ResponseBody
	public String itemRetrieve
	(@RequestParam("itemCode") String itemCd) {
	    itemService = new ItemService();
		ItemDTO itemDto = itemService.detail(itemCd);
	    System.out.println("상품상세보기 : " + itemDto);
	    return "itemRetrieve";
	}

//	@GetMapping("/itemList")
//	@ResponseBody
//	public List<ItemListDTO> List
//	@RequestParam(value = "curPage", required = false, defalutValue = "1")
}
