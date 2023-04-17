package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.ItemRetrieveDTO;
import com.example.dto.JoinItemDTO;
import com.example.dto.OptionDTO;
import com.example.service.FileUploadService;
import com.example.service.ItemService;

import io.swagger.annotations.ApiOperation;

// 상품리스트
// 상품상세보기


@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;

	ItemListDTO itemPage;
	@Autowired 
	FileUploadService fileUploadService;


	@GetMapping("/itemList/{cat}/{curPage}")
	@ApiOperation(value = "itemList")
	public ResponseEntity<JoinItemDTO> itemList(@PathVariable("cat") String cat, @PathVariable("curPage") Integer curPage){
		if (cat==null) {cat="FOOD";}
		if (curPage==null) {curPage =1;}
		JoinItemDTO itemLists = itemService.itemList(cat,curPage);
		return ResponseEntity.ok(itemLists);
	}
	
	@PutMapping(value = "/itemUpdate", consumes = "multipart/form-data")
	@ApiOperation(value="상품 정보 수정")
	public ComResponseEntity<Void> itemUpdate(@RequestParam(value="file",required = false) MultipartFile file, 
			@RequestParam("name") String name,@RequestParam("price") int price, 
			@RequestParam("category") String category, @RequestParam(value = "isOption", required = false) Boolean add,
			@RequestParam(value = "optionName") String optionName,
			@RequestParam(value = "option", required =false) List<String> option,@RequestParam("imgCd") int imgCd,
			@RequestParam("itCd") int itCd, @RequestParam(value = "optCd", required = false) Integer optCd) throws IOException {
		FileUploadDTO fileUploadDTO = new FileUploadDTO();
		if(file!=null) {
			fileUploadDTO.setDi(file.getContentType());
			fileUploadDTO.setImgNm(file.getOriginalFilename());
			fileUploadDTO.setFl(file.getBytes());
			fileUploadDTO.setSz(String.valueOf(file.getSize()));
			fileUploadDTO.setImgCd(imgCd);
		}
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItCd(itCd);
		itemDTO.setItNm(name);
		itemDTO.setCat(category);
		itemDTO.setPrice(price);
		itemDTO.setOptCd(optCd);
		if(add==true) {
			List<OptionDTO> optionList = new ArrayList<OptionDTO>();
			for(int i=0;i<option.size();i++) {				
				OptionDTO optionDTO = new OptionDTO();
				optionDTO.setOptNm(option.get(i));
				optionList.add(optionDTO);
			}
			fileUploadService.updateImgItemOpt(fileUploadDTO, itemDTO, optionName, optionList);
		}else {
			fileUploadService.updateImgItem(fileUploadDTO, itemDTO);
		}
		ComResponseDTO<Void> comResponseDto = new ComResponseDTO<Void>();
		comResponseDto.setMessage("상품수정 성공");
		return new ComResponseEntity<Void>(comResponseDto);
	}


	@GetMapping("/itemRetrieve/{itCd}") //단순 조회 부분
	@ApiOperation(value = "상품 상세히 보기")
	public ComResponseEntity<ItemRetrieveDTO> itemRetrieve (@PathVariable("itCd") Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = itemService.selectItemRetrieve(itCd);
	    
		return new ComResponseEntity<ItemRetrieveDTO>(new ComResponseDTO<ItemRetrieveDTO>(itCd + "상품정보", itemRetrieveDTO));
	}



}