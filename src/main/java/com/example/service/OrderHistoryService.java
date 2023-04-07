package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderHistoryDAO;

@Service
public class OrderHistoryService {
	@Autowired
	OrderHistoryDAO orderHistoryDao;
	
}
