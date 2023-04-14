package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.common.SessionAttributeManager;
import com.example.dto.ItemDTO;
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
	
	private static final Logger logger = LogManager.getLogger(FavoriteController.class);
	
	
	@GetMapping("/check/favorite/{mbId}")
	@ApiOperation(value = "찜 목록 조회")
	public ResponseEntity<List<ItemDTO>> mbFavoriteList(@PathVariable("mbId") String mbId){
		List<ItemDTO> favoriteList = itemService.mbFavoriteList(mbId);
		logger.info("찜 목록>>>>>>"+favoriteList);
		
		return new ResponseEntity<List<ItemDTO>>(favoriteList, HttpStatus.OK);
	}
	
	
	

	//수정완
//	@GetMapping("/check/favorite/{itCd}")
//	@ResponseBody
//	@ApiOperation(value = "favoriteList")
//	public ResponseEntity<List<ItemDTO>> favoriteList
//	(@RequestParam("itCd") List<Integer> itCd){
//		List<ItemDTO> favoriteLists = itemService.favoriteList(itCd);
//		return ResponseEntity.ok(favoriteLists);
//	}

	@PostMapping("/check/favorite/{itCd}")
	@ResponseBody
	@ApiOperation(value = "favoriteAdd")
	public ResponseEntity<Void> favoriteAdd
	(@PathVariable("itCd") int itCd) {
		String mbId=SessionAttributeManager.getMemberId();
//		String mbId="1";
		MemberItemDTO memberItemDTO = new MemberItemDTO();
		memberItemDTO.setMbId(mbId);
		memberItemDTO.setItCd(itCd);
		Integer favoriteAdd = itemService.favoriteAdd(memberItemDTO);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/check/favorite/{itCd}")
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
		return ResponseEntity.ok().build();
	}
}