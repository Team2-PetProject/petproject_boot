package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderDAO;

@Service("orderService")
public class OrderService {
	@Autowired
	OrderDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
}