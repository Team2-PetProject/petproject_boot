package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartDAO;
import com.example.dto.CartDTO;

@Service("cartService")
public class CartService {
	@Autowired
	CartDAO dao;
	@Autowired
	SqlSessionTemplate session;
	public void print() {
		System.out.println(session);
	}
	
	public int cartAdd(CartDTO cart) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int cartDelete(int cart_cd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int checkDelete() {
		// TODO Auto-generated method stub
		return 0;
	}


	public CartDTO specUpdate(int cart_cd, int item_amount) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}
