package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.OrderDAO;
import com.example.dto.CartDTO;
import com.example.dto.OrderHistoryDTO;
import com.example.dto.OrderInfoDTO;

@Service("orderService")
public class OrderService {
	@Autowired
	OrderDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	@Transactional
	public void orderDone(List<CartDTO> carts, OrderInfoDTO info, String member_cd) {
		dao.ordItem(member_cd, carts);
		dao.ordInfo(member_cd, info);
	}
	
	
	//주문내역


	public int totalCount(String member_cd) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<OrderHistoryDTO> orderSearch(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<OrderHistoryDTO> daySearch(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<OrderHistoryDTO> itemSearch(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}





	

	
}