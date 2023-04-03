package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;

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
import com.example.service.ImageService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/image")
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@PostMapping("/upload")
	@ApiOperation(value = "이미지 업로드")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("price") int price, @RequestParam("category") String category) throws IOException {
		
		FileUploadDTO fileUploadDTO = new FileUploadDTO();
		fileUploadDTO.setDi(file.getContentType());
		fileUploadDTO.setImgNm(file.getOriginalFilename());
		fileUploadDTO.setFl(file.getBytes());
		fileUploadDTO.setSz(String.valueOf(file.getSize()));
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItNm(name);
		itemDTO.setCat(category);
		itemDTO.setPrice(price);
		
		
		imageService.insertImgItem(fileUploadDTO, itemDTO);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));		
		
		return new ResponseEntity<String>("등록 성공", header, HttpStatus.OK);
	}
	
	@GetMapping("/view/{id}")
	@ApiOperation(value = "이미지 보기")
	public ResponseEntity<byte[]> findOne(@PathVariable int id){
		FileUploadDTO dto = imageService.findOne(id);
		System.out.println(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getDi());
		headers.add("Content-Length", String.valueOf(dto.getFl().length));
		return new ResponseEntity<byte[]>(dto.getFl(), headers, HttpStatus.OK);
	}
}
