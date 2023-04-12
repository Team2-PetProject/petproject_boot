package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
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
	private static final Logger logger = LogManager.getLogger(FileUploadController.class);
	@Autowired
	ItemService itemService; 
	@Autowired 
	FileUploadService fileUploadService; 
	 
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	@ApiOperation(value = "이미지 업로드")
	public ComResponseEntity<Void> handleFileUpload(@RequestParam("file") MultipartFile file, 
			@RequestParam("name") String name,@RequestParam("price") int price, 
			@RequestParam("category") String category, @RequestParam(value = "add", required = false) String add,
			@RequestParam(value = "optionName") String optionName,
			@RequestParam(value = "option", required =false) List<String> option) throws IOException {
		FileUploadDTO fileUploadDTO = new FileUploadDTO();
		fileUploadDTO.setDi(file.getContentType());
		fileUploadDTO.setImgNm(file.getOriginalFilename());
		fileUploadDTO.setFl(file.getBytes());
		fileUploadDTO.setSz(String.valueOf(file.getSize()));
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItNm(name);
		itemDTO.setCat(category);
		itemDTO.setPrice(price);
		if(add!=null) {
			List<OptionDTO> optionList = new ArrayList<OptionDTO>();
			for(int i=0;i<option.size();i++) {				
				OptionDTO optionDTO = new OptionDTO();
				optionDTO.setOptNm(option.get(i));
				optionList.add(optionDTO);
			}
			fileUploadService.insertImgItemOpt(fileUploadDTO, itemDTO, optionName, optionList);
		}else {
			fileUploadService.insertImgItem(fileUploadDTO, itemDTO);
		}
		ComResponseDTO<Void> comResponseDto = new ComResponseDTO<Void>();
		comResponseDto.setMessage("파일등록 성공");
		return new ComResponseEntity<Void>(comResponseDto);
	}
	
	@GetMapping("/view/{imgCd}")
	@ApiOperation(value = "이미지 보기")
	public ComResponseEntity<byte[]> findOne(@PathVariable int imgCd){
		FileUploadDTO dto = fileUploadService.findOne(imgCd);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", dto.getDi());
		headers.add("Content-Length", String.valueOf(dto.getFl().length));
		return new ComResponseEntity<byte[]>(new ComResponseDTO<byte[]>("이미지 보기", dto.getFl()));
	}
	
	
}
