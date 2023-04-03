package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoImpl.OrderHistoryDAOImpl;

@Service("orderHistoryService")
public class OrderHistoryService {
	@Autowired
	OrderHistoryDAOImpl dao;
	@Autowired
	SqlSessionTemplate session;
	
}
