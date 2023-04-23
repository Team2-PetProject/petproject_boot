package com.example.favorite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Item.dto.ItemDTO;
import com.example.Item.service.ItemService;
import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.favorite.dto.MemberItemDTO;
import com.example.member.service.MemberService;

import io.swagger.annotations.ApiOperation;

@Controller
public class FavoriteController {
	@Autowired
	MemberService memberService;
	@Autowired
	ItemService itemService;

	// 수정완
	@GetMapping("/check/favorite/{itCd}")
	@ResponseBody
	@ApiOperation(value = "favoriteList")
	public ComResponseEntity<List<ItemDTO>> favoriteList(@RequestParam("itCd") List<Integer> itCd) {
		List<ItemDTO> favoriteLists = itemService.favoriteList(itCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("찜 상품 정보", favoriteLists));
	}

	@PostMapping("/check/favorite/{itCd}")
	@ResponseBody
	@ApiOperation(value = "favoriteAdd")
	public ComResponseEntity<Void> favoriteAdd(@PathVariable("itCd") Integer itCd) {
		String mbId = SessionAttributeManager.getMemberId();
		MemberItemDTO memberItemDTO = new MemberItemDTO();
		memberItemDTO.setMbId(mbId);
		memberItemDTO.setItCd(itCd);
		itemService.favoriteAdd(memberItemDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("찜 상품 추가"));
	}

	@DeleteMapping("/check/favorite/itCd/{itCd}")
	@ResponseBody
	@ApiOperation(value = "favoriteDelete")
	public ComResponseEntity<Void> favoriteDelete(@PathVariable("itemCd") Integer itCd) {
		String mbId = SessionAttributeManager.getMemberId();
		MemberItemDTO memberItemDTO = new MemberItemDTO();
		memberItemDTO.setItCd(itCd);
		memberItemDTO.setMbId(mbId);
		itemService.favoriteDelete(memberItemDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("찜 상품 삭제"));
	}
}