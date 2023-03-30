package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartDAO;

@Service("cartService")
public class CartService {
	@Autowired
	CartDAO dao;
	@Autowired
	SqlSessionTemplate session;
	public void print() {
		System.out.println(session);
	}
	
}
