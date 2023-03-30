package com.example.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.ImageDTO;
import com.example.dto.ItemDTO;
import com.example.service.ImageService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/image")
public class ImageController {
	
	@Autowired
	ImageService service;
	

	@PostMapping("/upload")
	@ApiOperation(value = "이미지 업로드")
	public HashMap<String, Integer> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("price") int price, @RequestParam("category") String category) throws IOException {
		System.out.println(price + name + category);
		ImageDTO dto = new ImageDTO();
		dto.setMimeType(file.getContentType());
		dto.setOriginal_name(file.getOriginalFilename());
		dto.setData(file.getBytes());
		ItemDTO iDTO = new ItemDTO();
		iDTO.setItem_Name(name);
		iDTO.setItem_Category(category);
		iDTO.setItem_Price(price);
		
		int id = service.insertBoard(dto, iDTO);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		return map;
	}
	
	@GetMapping("/view/{id}")
	@ApiOperation(value = "이미지 보기")
	public ResponseEntity<byte[]> findOne(@PathVariable int id){
		ImageDTO dto = service.findOne(id);
		System.out.println(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getMimeType());
		headers.add("Content-Length", String.valueOf(dto.getData().length));
		return new ResponseEntity<byte[]>(dto.getData(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "회원")
	public HashMap<String, Object> user(@PathVariable String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", "홍길동");
		map.put("age", 20);
		return map;
	}
}
