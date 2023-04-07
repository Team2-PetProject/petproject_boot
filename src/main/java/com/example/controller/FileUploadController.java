package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;
import com.example.dto.OptionDTO;
import com.example.dto.OptionTypeDTO;
import com.example.service.FileUploadService;
import com.example.service.ItemService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {
	
	@Autowired
	ItemService itemService; 
	@Autowired 
	FileUploadService fileUploadService; 
	 
	@PostMapping("/upload")
	@ApiOperation(value = "이미지 업로드")
	public ResponseEntity<String> handleFileUpload(@RequestParam("di") String di, @RequestParam("file") MultipartFile file, 
			@RequestParam("name") String name,@RequestParam("price") int price, 
			@RequestParam("category") String category, @RequestParam(value = "add", required = false) String add,
			@RequestParam(value = "optionName") String optionName,
			@RequestParam(value = "option", required =false) List<String> option) throws IOException {
		System.out.println(di);
//		FileUploadDTO fileUploadDTO = new FileUploadDTO();
//		fileUploadDTO.setDi(di);
//		fileUploadDTO.setImgNm(file.getOriginalFilename());
//		fileUploadDTO.setFl(file.getBytes());
//		fileUploadDTO.setSz(String.valueOf(file.getSize()));
//		
//		ItemDTO itemDTO = new ItemDTO();
//		itemDTO.setItNm(name);
//		itemDTO.setCat(category);
//		itemDTO.setPrice(price);
//		
//		if(add!=null) {
//			OptionTypeDTO optionTypeDTO = new OptionTypeDTO();
//			optionTypeDTO.setTyNm(optionName);
//			List<OptionDTO> optionList = new ArrayList<OptionDTO>();
//			for(int i=0;i<option.size();i++) {
//				OptionDTO optionDTO = new OptionDTO();
//				optionDTO.setOptNm(option.get(i));
//				optionList.add(optionDTO); 
//			}
//			
//			fileUploadService.insertImgItemOpt(fileUploadDTO, itemDTO, optionTypeDTO, optionList);
//		}else {
//			fileUploadService.insertImgItem(fileUploadDTO, itemDTO);
//		}
//		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));		
		 
		return new ResponseEntity<String>("등록 성공", header, HttpStatus.OK);
	}
	
	@GetMapping("/view/{imgCd}")
	@ApiOperation(value = "이미지 보기")
	public ResponseEntity<byte[]> findOne(@PathVariable int imgCd){
		FileUploadDTO dto = fileUploadService.findOne(imgCd);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getDi());
		headers.add("Content-Length", String.valueOf(dto.getFl().length));
		return new ResponseEntity<byte[]>(dto.getFl(), headers, HttpStatus.OK);
	}
	
	
}
