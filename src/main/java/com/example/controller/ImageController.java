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

import com.example.dto.FileUploadDTO;
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
		
		FileUploadDTO dto = new FileUploadDTO();
		dto.setDi(file.getContentType());
		dto.setImgNm(file.getOriginalFilename());
		dto.setFl(file.getBytes());
		dto.setSz(String.valueOf(file.getSize()));
		ItemDTO iDTO = new ItemDTO();
		iDTO.setItNm(name);
		iDTO.setCat(category);
		iDTO.setPrice(price);
		
		int id = service.insertBoard(dto, iDTO);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		return map;
	}
	
	@GetMapping("/view/{id}")
	@ApiOperation(value = "이미지 보기")
	public ResponseEntity<byte[]> findOne(@PathVariable int id){
		FileUploadDTO dto = service.findOne(id);
		System.out.println(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getDi());
		headers.add("Content-Length", String.valueOf(dto.getFl().length));
		return new ResponseEntity<byte[]>(dto.getFl(), headers, HttpStatus.OK);
	}
	
}
