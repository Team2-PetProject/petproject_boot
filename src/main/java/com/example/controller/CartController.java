package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.dto.AmountUpdateDTO;
import com.example.dto.CartConfirmDTO;
import com.example.dto.CartDTO;
import com.example.dto.SpecUpdateDTO;
import com.example.service.CartService;
import com.example.service.MemberService;

import io.swagger.annotations.ApiOperation;
@RestController
public class CartController {
	@Autowired
	MemberService memberService;
	@Autowired
	CartService cartService;
	
	//카트조회
	@GetMapping("/check/cartList")
	@ApiOperation(value = "cartList")
	@CrossOrigin
	public ResponseEntity<List<CartConfirmDTO>> cartList(){
		List<CartConfirmDTO> cartLists = cartService.cartList();
		return ResponseEntity.ok(cartLists);
	}


	@PostMapping("/check/cartAdd")
	@ApiOperation(value = "cartAdd")
	public ComResponseEntity<Map<String, Object>> CartAdd(CartDTO cart){
//		 String mbId=SessionAttributeManager.getMemberId();
		 String mbId="1";
		 cart.setMbId(mbId);
		 Integer AddItem = cartService.cartAdd(cart);
		 Map<String, Object> cartAdd = new HashMap<String, Object>();
		 cartAdd.put("success", AddItem > 0);
		 cartAdd.put("itemCd", cart.getCartCd());
		 return new ComResponseEntity<>(new ComResponseDTO<>("카트 저장", cartAdd));
	}

	//한개 삭제 메소드
	@DeleteMapping("/check/cartDelete/{cartCd}")
	@ApiOperation(value = "cartDelete")
	public ResponseEntity<Void>cartDelete(@PathVariable("cartCd") int cartCd) {
		//cartCd로 바로 삭제
		Integer deleteOne = cartService.cartDelete(cartCd);
		System.out.println("하나 삭제된 갯수 : "+ deleteOne);
		return ResponseEntity.ok().build();
	}

	//전체 삭제
	@DeleteMapping("/check/checkDelete")
	@ApiOperation(value = "checkDelete")
	public ResponseEntity<Void> checkDelete(@RequestParam("cartCd") List<Integer>list) {
		System.out.println(list);
		Integer allDelete = cartService.checkDelete(list);
		System.out.println("전체 삭제  : " + allDelete);
		return ResponseEntity.ok().build();
	}

	//상품 옵션 변경
	@PutMapping("/check/specUpdate/{cartCd}/option/{optCd}")
	@ApiOperation(value = "specUpdate")
	public ResponseEntity<Integer>specUpdate(@PathVariable("cartCd") int cartCd, @PathVariable("optCd") int optCd){
//		String mbId = SessionAttributeManager.getMemberId();
		String mbId = "1";
		SpecUpdateDTO specUpdateDTO = new SpecUpdateDTO();
		specUpdateDTO.setMbId(mbId);
		specUpdateDTO.setCartCd(cartCd);
		specUpdateDTO.setOptCd(optCd);
		Integer changeSpec=cartService.specUpdate(specUpdateDTO);
		return ResponseEntity.ok(changeSpec);
	}

	//수량 변경
	@PutMapping("/check/specUpdate/{cartCd}/amt/{amount}")
	@ApiOperation(value = "amountUpdate")
	public ResponseEntity<Integer> amountUpdate(@PathVariable("cartCd") int cartCd, @PathVariable("amount") int amount){
//		String mbId = SessionAttributeManager.getMemberId();
		String mbId = "1";
		AmountUpdateDTO amountUpdateDTO = new AmountUpdateDTO();
		amountUpdateDTO.setMbId(mbId);
		amountUpdateDTO.setAmount(amount);
		amountUpdateDTO.setCartCd(cartCd);
		int changeAmount = cartService.amountUpdate(amountUpdateDTO);
		return ResponseEntity.ok(changeAmount);
	}
}