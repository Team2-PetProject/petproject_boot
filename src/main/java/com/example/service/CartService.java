package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartDAO;
import com.example.dto.AmountUpdateDTO;
import com.example.dto.CartDTO;
import com.example.dto.SpecUpdateDTO;

@Service
public class CartService {
	@Autowired
	CartDAO dao;

	public int cartAdd(CartDTO cart) {
		return dao.cartAdd(cart);

	}

	public int cartDelete(int cartCd) {
		return dao.cartDelete(cartCd);
	}

	public int checkDelete(List<Integer> list) {
		return dao.checkDelete(list);
	}

	public int specUpdate(SpecUpdateDTO specUpdateDTO) {

		return dao.specUpdate(specUpdateDTO);
	}

	public int amountUpdate(AmountUpdateDTO amountUpdateDTO) {

		return dao.amountUpdate(amountUpdateDTO);
	}


}