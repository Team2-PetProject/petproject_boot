package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.SessionAttributeManager;
import com.example.dao.CartDAO;
import com.example.dto.AmountUpdateDTO;
import com.example.dto.ArrayOptCdDTO;
import com.example.dto.CartConfirmDTO;
import com.example.dto.CartDTO;
import com.example.dto.SpecUpdateDTO;

@Service
public class CartService {

	@Autowired
	CartDAO cartDao;

	@Transactional
	public int cartAdd(CartDTO cartDTO) {
		return cartDao.cartAdd(cartDTO);

	}

	@Transactional
	public int cartDelete(int cartCd) {
		return cartDao.cartDelete(cartCd);
	}

	@Transactional
	public int checkDelete(List<Integer> list) {
		Integer deleteCount = 0;
		for (Integer cartCd : list) {
			deleteCount = deleteCount + cartDao.checkDelete(cartCd);
		}
		return deleteCount;
	}

	@Transactional
	public int specUpdate(SpecUpdateDTO specUpdateDTO) {

		return cartDao.specUpdate(specUpdateDTO);
	}

	@Transactional
	public int amountUpdate(AmountUpdateDTO amountUpdateDTO) {

		return cartDao.amountUpdate(amountUpdateDTO);
	}

	@Transactional
	public List<CartConfirmDTO> cartList() {
//		String mbId = SessionAttributeManager.getMemberId();
		String mbId = "123";
		List<CartConfirmDTO> cartLists = cartDao.cartList(mbId);
		List<CartConfirmDTO> reCartList = new ArrayList<CartConfirmDTO>();
		for (CartConfirmDTO cartConfirmDTO : cartLists) {
			Integer cartCd = cartConfirmDTO.getCartCd();
			List<ArrayOptCdDTO> optList = cartDao.typeSearch(cartCd);
			cartConfirmDTO.setOptCds(optList);
			reCartList.add(cartConfirmDTO);
		}
		System.err.println(reCartList);
		return reCartList;
	}


}