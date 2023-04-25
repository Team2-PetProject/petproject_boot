package com.example.CartOrder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CartOrder.dao.CartDAO;
import com.example.CartOrder.dto.AmountUpdateDTO;
import com.example.CartOrder.dto.ArrayOptCdDTO;
import com.example.CartOrder.dto.CartConfirmDTO;
import com.example.CartOrder.dto.CartDTO;
import com.example.CartOrder.dto.SpecUpdateDTO;
import com.example.common.SessionAttributeManager;

@Service
public class CartService {

	@Autowired
	CartDAO cartDao;

	@Transactional
	public Integer cartAdd(CartDTO cartDTO) {
		return cartDao.cartAdd(cartDTO);
	}

	@Transactional
	public Integer cartDelete(Integer cartCd) {
		return cartDao.cartDelete(cartCd);
	}

	@Transactional
	public Integer checkDelete(List<Integer> list) {
		Integer deleteCount = 0;
		for (Integer cartCd : list) {
			deleteCount = deleteCount + cartDao.checkDelete(cartCd);
		}
		return deleteCount;
	}

	@Transactional
	public Integer specUpdate(SpecUpdateDTO specUpdateDTO) {
		return cartDao.specUpdate(specUpdateDTO);
	}

	@Transactional
	public Integer amountUpdate(AmountUpdateDTO amountUpdateDTO) {
		return cartDao.amountUpdate(amountUpdateDTO);
	}

	@Transactional
	public List<CartConfirmDTO> cartList() {
		String mbId = SessionAttributeManager.getMemberId();
		List<CartConfirmDTO> cartLists = cartDao.cartList(mbId);
		List<CartConfirmDTO> reCartList = new ArrayList<CartConfirmDTO>();

		for (CartConfirmDTO cartConfirmDTO : cartLists) {
			Integer cartCd = cartConfirmDTO.getCartCd();
			List<ArrayOptCdDTO> optList = cartDao.typeSearch(cartCd);
			cartConfirmDTO.setOptCds(optList);
			reCartList.add(cartConfirmDTO);
		}
		return reCartList;
	}

}