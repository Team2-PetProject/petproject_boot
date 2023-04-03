package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
	public HashMap<String,Object> handleFileUpload(@RequestParam("file") MultipartFile file, 
			@RequestParam("name") String name, @RequestParam("price") int price, 
			@RequestParam("category") String category, @RequestParam("option") List<String> option) 
					throws IOException {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		String add = "F";
		if(option != null) {
			add = "T";
			for (String opt : option) {
				list.add(new ItemDTO(0, 0, name, price, 0, category, opt, "T"));
			}
		}else {
			list.add(new ItemDTO(0, 0, name, price, 0, category, "", "F"));
		}
		ImageDTO dto = new ImageDTO();
		dto.setMimeType(file.getContentType());
		dto.setOriginal_name(file.getOriginalFilename());
		dto.setData(file.getBytes());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		int id = service.insertBoard(dto, map);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("id", 1);
		result.put("add", add);
		return result;
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
}
