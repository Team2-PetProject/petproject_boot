package com.example.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.PagingDTO;
import com.example.common.SessionAttributeManager;
import com.example.dto.ItemListDTO;
import com.example.dto.ItemPageDTO;
import com.example.dto.ItemRetrieveDTO;
import com.example.dto.OptionDTO;
import com.example.dto.OrderSearchDTO;
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
	//4
	@GetMapping("/itemList/{cat}") //단순 조회는 get
	public String itemList
	(@RequestParam(value = "cat", defaultValue = "food") 
	//path에서 안되는데 굳이 써야할까...
	String item_cat, Model model) {
//		itemService = new ItemService();
//	    List<OptionDTO> list = itemService.itemList(item_cat);
//	    System.out.println("itemList: " + list);
//	    model.addAttribute("itemList", list);
//	    return "main";
		return null;
	} 

	
	
	@GetMapping("/itemRetrieve/{itCd}") //단순 조회 부분
	@ApiOperation(value = "상품 상세히 보기")
	public ResponseEntity<ItemRetrieveDTO> itemRetrieve (@PathVariable("itCd") Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = itemService.selectItemRetrieve(itCd);
	    
	    HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));	
	    
	    return new ResponseEntity<ItemRetrieveDTO>(itemRetrieveDTO, header, HttpStatus.OK);
	}
	
	@PostMapping("/itemPage/{curpage}")
	@ApiOperation(value = "에윽")
	private ItemPageDTO searchPaging(@PathVariable("curPage")Integer curPage) {
		  
		   String mbId = SessionAttributeManager.getMemberId();
		   Integer totalCount = itemService.totalCount(mbId);
		   Integer perPage = itemPage.getPerPage();
		   Integer totalPage = (int)Math.ceil(totalCount / perPage);
		   if (curPage==0) {curPage=1;}
		   Integer startIdx = (curPage-1) * perPage+1;
		   Integer endIdx = perPage*startIdx;
		   ItemPageDTO itemPage= new ItemPageDTO();
		   itemPage.setPerPage(Integer.toString(perPage));
		   itemPage.setStartIdx(Integer.toString(startIdx));
		   itemPage.setEndIdx(Integer.toString(startIdx));
		   
		   return itemPage;
		}
	


}