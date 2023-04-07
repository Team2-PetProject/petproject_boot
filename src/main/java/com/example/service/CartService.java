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
	CartDAO dao;

	public int cartAdd(CartDTO cart) {
		//getopt ==if절 추가로 맵퍼 두개작성은 어떨까?
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