package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.FileUploadDTO;
import com.example.service.FileUploadService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/file")
public class FileController {
	private static final Logger logger = LogManager.getLogger(FileController.class);
	@Autowired 
	FileUploadService fileUploadService; 
	 
	@GetMapping("/view/{imgCd}")
	@ApiOperation(value = "이미지 보기")
	public ResponseEntity<byte[]> findOne(@PathVariable int imgCd){
		FileUploadDTO dto = fileUploadService.findOne(imgCd);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getDi());
		headers.add("Content-Length", String.valueOf(dto.getFl().length));
		return new ResponseEntity<byte[]>(dto.getFl(), headers, HttpStatus.OK);
//		return new ComResponseEntity<>(new ComResponseDTO<>("이미지 보기", dto));
	}
	
	
}