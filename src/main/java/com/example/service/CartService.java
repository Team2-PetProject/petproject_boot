package com.example.service;

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
	
}
