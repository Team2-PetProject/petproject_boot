package com.example.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Item.dto.ItemDTO;
import com.example.Item.dto.OptionDTO;
import com.example.Item.service.ItemService;
import com.example.admin.dto.AdminItemDTO;
import com.example.admin.dto.FileUploadDTO;
import com.example.admin.dto.ItemInfoDTO;
import com.example.admin.service.FileUploadService;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class ManageController {
	@Autowired
	ItemService itemService; 
	@Autowired 
	FileUploadService fileUploadService; 
	 
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	@CrossOrigin
	@ApiOperation(value = "이미지 업로드")
	public ComResponseEntity<Void> handleFileUpload(@RequestParam("file") MultipartFile file, 
			@RequestParam("file") MultipartFile detailFile,
			@RequestParam("name") String name,@RequestParam("price") Integer price, 
			@RequestParam("category") String category, @RequestParam(value = "isOption", required = false) Boolean add,
			@RequestParam(value = "optionName") String optionName,
			@RequestParam(value = "option", required =false) List<String> option) throws IOException {
		FileUploadDTO fileUploadDTO = new FileUploadDTO();
		fileUploadDTO.setDi(file.getContentType());
		fileUploadDTO.setImgNm(file.getOriginalFilename());
		fileUploadDTO.setFl(file.getBytes());
		fileUploadDTO.setSz(String.valueOf(file.getSize()));
		
		ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
		itemInfoDTO.setDi(file.getContentType());
		itemInfoDTO.setImgNm(file.getOriginalFilename());
		itemInfoDTO.setFl(file.getBytes());
		itemInfoDTO.setSz(file.getSize());
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItNm(name);
		itemDTO.setCat(category);
		itemDTO.setPrice(price);
		if(add==true) {
			List<OptionDTO> optionList = new ArrayList<OptionDTO>();
			for(int i=0;i<option.size();i++) {				
				OptionDTO optionDTO = new OptionDTO();
				optionDTO.setOptNm(option.get(i));
				optionList.add(optionDTO);
			}
			fileUploadService.insertImgItemOpt(fileUploadDTO,itemInfoDTO, itemDTO, optionName, optionList);
		}else {
			fileUploadService.insertImgItem(fileUploadDTO,itemInfoDTO, itemDTO);
		}
		ComResponseDTO<Void> comResponseDto = new ComResponseDTO<Void>();
		comResponseDto.setMessage("파일등록 성공");
		return new ComResponseEntity<Void>(comResponseDto);
	}
	
	@GetMapping("/view/{imgCd}")
	@CrossOrigin
	@ApiOperation(value = "이미지 보기")
	public ResponseEntity<byte[]> findOne(@PathVariable Integer imgCd){
		FileUploadDTO dto = fileUploadService.findOne(imgCd);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getDi());
		headers.add("Content-Length", String.valueOf(dto.getFl().length));
		return new ResponseEntity<byte[]>(dto.getFl(), headers, HttpStatus.OK);
//		return new ComResponseEntity<>(new ComResponseDTO<>("이미지 보기", dto));
	}
	
	@PutMapping(value = "/itemUpdate", consumes = "multipart/form-data")
	@ApiOperation(value="상품 정보 수정")
	public ComResponseEntity<Void> itemUpdate(@RequestParam(value="file",required = false) MultipartFile file, 
			@RequestParam(value = "detailFile",required = false) MultipartFile detailFile,
			@RequestParam("name") String name,@RequestParam("price") Integer price, 
			@RequestParam("category") String category, @RequestParam(value = "isOption", required = false) Boolean add,
			@RequestParam(value = "optionName") String optionName,
			@RequestParam(value = "option", required =false) List<String> option,@RequestParam("imgCd") Integer imgCd, @RequestParam("itInfoCd") Integer itInfoCd,
			@RequestParam("itCd") Integer itCd, @RequestParam(value = "optCd", required = false) Integer optCd) throws IOException {
		FileUploadDTO fileUploadDTO = new FileUploadDTO();
		if(file!=null) {
			fileUploadDTO.setDi(file.getContentType());
			fileUploadDTO.setImgNm(file.getOriginalFilename());
			fileUploadDTO.setFl(file.getBytes());
			fileUploadDTO.setSz(String.valueOf(file.getSize()));
			fileUploadDTO.setImgCd(imgCd);
		}
		ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
		if(detailFile!=null) {
			itemInfoDTO.setDi(detailFile.getContentType());
			itemInfoDTO.setImgNm(detailFile.getOriginalFilename());
			itemInfoDTO.setFl(detailFile.getBytes());
			itemInfoDTO.setSz(detailFile.getSize());
			itemInfoDTO.setItCd(itCd);
			itemInfoDTO.setItInfoCd(itInfoCd);
		}
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItCd(itCd);
		itemDTO.setItNm(name);
		itemDTO.setCat(category);
		itemDTO.setPrice(price);
		itemDTO.setOptCd(optCd);
		if(add==true) {
			List<OptionDTO> optionList = new ArrayList<OptionDTO>();
			for(Integer i=0;i<option.size();i++) {				
				OptionDTO optionDTO = new OptionDTO();
				optionDTO.setOptNm(option.get(i));
				optionList.add(optionDTO);
			}
			fileUploadService.updateImgItemOpt(fileUploadDTO,itemInfoDTO, itemDTO, optionName, optionList);
		}else {
			fileUploadService.updateImgItem(fileUploadDTO,itemInfoDTO, itemDTO);
		}
		ComResponseDTO<Void> comResponseDto = new ComResponseDTO<Void>();
		comResponseDto.setMessage("상품수정 성공");
		return new ComResponseEntity<Void>(comResponseDto);
	}
	
	@DeleteMapping("/itemRetrieve/del/{itCd}/{imgCd}")
	@ApiOperation(value = "상품 삭제하기")
	public ComResponseEntity<Void> deleteItem(@PathVariable("itCd") Integer itCd, @PathVariable("imgCd") Integer imgCd){
		itemService.deleteItem(itCd);
		fileUploadService.deleteFile(imgCd, itCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("상품 삭제 성공"));
	} 
	
	@GetMapping("/itemList/{curPage}")
	@ApiOperation(value = "관리자 상품조회")
	public ComResponseEntity<AdminItemDTO> adminList(@PathVariable("curPage") Integer curPage){
		AdminItemDTO itemList = itemService.adminList(curPage);
		return new ComResponseEntity<>(new ComResponseDTO<>(curPage + "페이지 상품", itemList));
	}

	
}
