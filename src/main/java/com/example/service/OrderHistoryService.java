package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderHistoryDAO;

@Service("OrderHistoryService")
public class OrderHistoryService {
	@Autowired
	OrderHistoryDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
}
