package com.example.CartOrder.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CartOrder.dto.AmountUpdateDTO;
import com.example.CartOrder.dto.CartConfirmDTO;
import com.example.CartOrder.dto.CartDTO;
import com.example.CartOrder.dto.SpecUpdateDTO;
import com.example.CartOrder.service.CartService;
import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;

import io.swagger.annotations.ApiOperation;

@RestController
public class CartController {
	@Autowired
	CartService cartService;

	@GetMapping("/check/cartList")
	@ApiOperation(value = "cartList")
	@CrossOrigin
	public ResponseEntity<List<CartConfirmDTO>> cartList() {
		List<CartConfirmDTO> cartLists = cartService.cartList();
		return ResponseEntity.ok(cartLists);
	}

	@PostMapping("/check/cartAdd")
	@ApiOperation(value = "cartAdd")
	public ComResponseEntity<Map<String, Object>> CartAdd(@RequestBody CartDTO cart) {
		String mbId = SessionAttributeManager.getMemberId();
		cart.setMbId(mbId);
		Integer AddItem = cartService.cartAdd(cart);
		Map<String, Object> cartAdd = new HashMap<String, Object>();
		cartAdd.put("success", AddItem > 0);
		cartAdd.put("itemCd", cart.getCartCd());
		return new ComResponseEntity<>(new ComResponseDTO<>("장바구니 추가 성공", cartAdd));
	}

	// 한개 삭제 메소드
	@DeleteMapping("/check/cartDelete/{cartCd}")
	@ApiOperation(value = "cartDelete")
	public ComResponseEntity<Void> cartDelete(@PathVariable("cartCd") Integer cartCd) {
		// cartCd로 바로 삭제
		Integer deleteOne = cartService.cartDelete(cartCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("장바구니 상품 삭제 성공"));
	}

	// 전체 삭제
	@DeleteMapping(value = "/check/checkDelete")
	@ApiOperation(value = "checkDelete")
	public ComResponseEntity<Void> checkDelete(@RequestParam("cartCd") List<Integer> list) {
		Integer allDelete = cartService.checkDelete(list);
		return new ComResponseEntity<>(new ComResponseDTO<>("장바구니 상품 전체 삭제 성공"));
	}

	// 상품 옵션 변경
	@PutMapping("/check/specUpdate/{cartCd}/option/{optCd}")
	@ApiOperation(value = "specUpdate")
	public ComResponseEntity<Integer> specUpdate(@PathVariable("cartCd") Integer cartCd, @PathVariable("optCd") int optCd) {
		String mbId = SessionAttributeManager.getMemberId();
		SpecUpdateDTO specUpdateDTO = new SpecUpdateDTO();
		specUpdateDTO.setMbId(mbId);
		specUpdateDTO.setCartCd(cartCd);
		specUpdateDTO.setOptCd(optCd);
		Integer changeSpec = cartService.specUpdate(specUpdateDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("상품 옵션 변경 성공", changeSpec));
	}

	// 수량 변경
	@PutMapping("/check/specUpdate/{cartCd}/amt/{amount}")
	@ApiOperation(value = "amountUpdate")
	public ComResponseEntity<Integer> amountUpdate(@PathVariable("cartCd") Integer cartCd,
			@PathVariable("amount") Integer amount) {
		String mbId = SessionAttributeManager.getMemberId();
		AmountUpdateDTO amountUpdateDTO = new AmountUpdateDTO();
		amountUpdateDTO.setMbId(mbId);
		amountUpdateDTO.setAmount(amount);
		amountUpdateDTO.setCartCd(cartCd);
		Integer changeAmount = cartService.amountUpdate(amountUpdateDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("수량 변경 성공", changeAmount));
	}
}