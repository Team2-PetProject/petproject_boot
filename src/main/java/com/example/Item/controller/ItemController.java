package com.example.Item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Item.dto.ItemListDTO;
import com.example.Item.dto.ItemRetrieveDTO;
import com.example.Item.dto.JoinItemDTO;
import com.example.Item.service.ItemService;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;

import io.swagger.annotations.ApiOperation;

// 상품리스트
// 상품상세보기


@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;

	ItemListDTO itemPage;

	@GetMapping("/itemList/{cat}/{curPage}")
	@ApiOperation(value = "itemList")
	public ComResponseEntity<JoinItemDTO> itemList(@PathVariable("cat") String cat, @PathVariable("curPage") Integer curPage){
		if (cat==null) {cat="FOOD";}
		if (curPage==null) {curPage =1;}
		JoinItemDTO itemLists = itemService.itemList(cat,curPage);
		return new ComResponseEntity<>(new ComResponseDTO<>("카테고리별 상품 정보", itemLists));
	}
	
	

	@GetMapping("/itemRetrieve/{itCd}") //단순 조회 부분
	@ApiOperation(value = "상품 상세히 보기")
	public ComResponseEntity<ItemRetrieveDTO> itemRetrieve (@PathVariable("itCd") Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = itemService.selectItemRetrieve(itCd);
	    
		return new ComResponseEntity<ItemRetrieveDTO>(new ComResponseDTO<ItemRetrieveDTO>(itCd + "상품정보", itemRetrieveDTO));
	}
	
	


}