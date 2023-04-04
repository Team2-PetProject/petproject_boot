package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoImpl.CartDAOImpl;
import com.example.dto.CartDTO;

@Service
public class CartService {
	@Autowired
	CartDAOImpl dao;

	public int cartAdd(CartDTO cart) {
		return dao.cartAdd(cart);
	}
	
	public int cartDelete(int cart_cd) {
		return dao.cartDelete(cart_cd);
	}

	public int checkDelete(List<Integer> list) {
		return dao.checkDelete(list);
	}

	public int specUpdate(HashMap<String, Integer> map) {

		return dao.specUpdate(map);
	}
	
	public int amountUpdate(HashMap<String, Integer> map) {

		return dao.amountUpdate(map);
	}







	
	
}
