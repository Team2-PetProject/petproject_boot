package com.example.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dto.PagingDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.ItemPageDTO;
import com.example.dto.ItemRetrieveDTO;
import com.example.service.ItemService;
import com.example.service.MemberService;

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
	@ApiOperation(value = "상품 상세히 보기")
	public ResponseEntity<ItemRetrieveDTO> itemRetrieve (@PathVariable("itCd") Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = itemService.selectItemRetrieve(itCd);
	    
	    HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));	
	    
	    return new ResponseEntity<ItemRetrieveDTO>(itemRetrieveDTO, header, HttpStatus.OK);
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
	


}