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

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.common.dto.PagingDTO;
import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.ItemPageDTO;
import com.example.dto.ItemRetrieveDTO;
import com.example.dto.OptionDTO;
import com.example.service.FileUploadService;
import com.example.service.ItemService;
import com.example.service.MemberService;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import io.swagger.annotations.ApiOperation;

// 상품리스트
// 상품상세보기
	

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	MemberService memberService;
	@Autowired 
	FileUploadService fileUploadService;
	//10시10.

	ItemListDTO itemPage;

//	@GetMapping("/itemList/{cat}") //단순 조회는 get
//	public String itemList
//	(@RequestParam(value = "cat", defaultValue = "food") 
//	//path에서 안되는데 굳이 써야할까...
//	String item_cat, Model model) {
////		itemService = new ItemService();
////	    List<OptionDTO> list = itemService.itemList(item_cat);
////	    System.out.println("itemList: " + list);
////	    model.addAttribute("itemList", list);
////	    return "main";
//		return null;
//	} 

	@GetMapping("/itemList/{cat}")//("/itemList") //단순 조회는 get
	public ResponseEntity<ItemListDTO> itemList(@PathVariable("cat") 
	//public ResponseEntity<ItemDTO> itemList(@PathVariable("cat") 
//	(@RequestParam(value = "cat", defaultValue = "food") 
	String cat) {
	   ItemListDTO itemListDTO = itemService.itemList(cat);
	   //ItemDTO itemDTO = itemService.itemList(cat);
	   HttpHeaders header = new HttpHeaders();
	   header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
	   
	    //return new ResponseEntity<ItemDTO>(itemDTO, header, HttpStatus.OK);
	    return new ResponseEntity<ItemListDTO>(itemListDTO, header, HttpStatus.OK);
	} 
	
	@GetMapping("/itemRetrieve/{itCd}") //단순 조회 부분
	@CrossOrigin
	@ApiOperation(value = "상품 상세히 보기")
	public ComResponseEntity<ItemRetrieveDTO> itemRetrieve (@PathVariable("itCd") Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = itemService.selectItemRetrieve(itCd);
	    
		return new ComResponseEntity<ItemRetrieveDTO>(new ComResponseDTO<ItemRetrieveDTO>(itCd + "상품정보", itemRetrieveDTO));
	}
	
	@PutMapping(value = "/itemUpdate", consumes = "multipart/form-data")
	@CrossOrigin
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
	
	@PostMapping("/itemPage/{curPage}")
	@ApiOperation(value = "에윽")
	private ItemPageDTO searchPaging(@PathVariable("curPage")Integer curPage) {
		  System.out.println(curPage);
		   Integer totalCount = itemService.totalCount();
//		   Integer perPage = itemPage.getPerPage();
//		   System.out.println(perPage);
//		   Integer totalPage = (int)Math.ceil(totalCount / perPage);
		   PagingDTO pagingDto = new PagingDTO();
		   pagingDto.setCurPage(curPage);
		   pagingDto.setPerPage(8);
		   Integer startIdx = pagingDto.getStartIdx();
		   Integer endIdx = pagingDto.getEndIdx();
		   ItemPageDTO itemPage= new ItemPageDTO();
		   itemPage.setPerPage(Integer.toString(8));
		   itemPage.setStartIdx(Integer.toString(startIdx));
		   itemPage.setEndIdx(Integer.toString(endIdx));
		   
		   return itemPage;
	}
	
//	@DeleteMapping("/itemRetrieve/del/{itCd}")
//	@ApiOperation(value="상품 삭제")
//	private ComResponseEntity<Void> deleteItem(@PathVariable("idCd") Integer itCd){
//		itemService.deleteItem(itCd);
//		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>(itCd + "번 상품 삭제 성공");
//		return new ComResponseEntity<Void>(comResponseDTO);
//	}
	


}