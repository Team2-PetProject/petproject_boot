package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.common.SessionAttributeManager;
import com.example.dto.MemberItemDTO;
import com.example.service.ItemService;
import com.example.service.MemberService;

import io.swagger.annotations.ApiOperation;
@Controller
public class FavoriteController {
	@Autowired
	MemberService memberService;
	@Autowired
	ItemService itemService;
	//다시 상품 상세보기로 돌려야함
	//찜목록 추가 restful로 변경필요 //
	//03.31 오늘은 건들지 말자.


	//상세페이지에서 찜 버튼을 눌러도 그대로 그 상품페이지다.
	@PostMapping("/check/favorite/{itemCd}")
	@ResponseBody
	@ApiOperation(value = "favoriteAdd")
	public ResponseEntity<Void> favoriteAdd
	(@PathVariable("itemCd") int itemCd) {
		String mbId=SessionAttributeManager.getMemberId();
//		String mbId="1";
		MemberItemDTO memberItemDTO = new MemberItemDTO();
		memberItemDTO.setMbId(mbId);
		memberItemDTO.setItCd(itemCd);
		Integer favoriteAdd = itemService.favoriteAdd(memberItemDTO);
		System.out.println("favoriteAdd : " + favoriteAdd);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/check/favorite/{itemCd}")
	@ResponseBody
	@ApiOperation(value = "favoriteDelete")
	public ResponseEntity<Void> favoriteDelete
	(@PathVariable("itemCd") int itCd) {
//		String mbId=SessionAttributeManager.getMemberId();
		String mbId="1";
		MemberItemDTO memberItemDTO = new MemberItemDTO();
		memberItemDTO.setItCd(itCd);
		memberItemDTO.setMbId(mbId);
		Integer favoriteDel = itemService.favoriteDelete(memberItemDTO);
		System.out.println("해당 "+ favoriteDel +" 번호 가 삭제되었습니다");
		return ResponseEntity.ok().build();
	}
}
