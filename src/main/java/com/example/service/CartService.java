package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartDAO;
import com.example.dto.CartDTO;

@Service
public class CartService {
	@Autowired
	CartDAO cartDao;
	
	public int cartAdd(CartDTO cart) {
		return cartDao.cartAdd(cart);
	}
	
	public int cartDelete(int cartCd) {
		return cartDao.cartDelete(cartCd);
	}

	public int checkDelete(List<Integer> list) {
		return cartDao.checkDelete(list);
	}

	public int specUpdate(HashMap<String, Integer> map) {

		return cartDao.specUpdate(map);
	}
	
	public int amountUpdate(HashMap<String, Integer> map) {

		return cartDao.amountUpdate(map);
	}







	
	
}