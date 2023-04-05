package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.daoImpl.OrderDAOImpl;
import com.example.dto.CartDTO;
import com.example.dto.OrderHistoryDTO;
import com.example.dto.OrderInfoDTO;

@Service
public class OrderService {
	@Autowired
	OrderDAOImpl dao;

	
	@Transactional
	public void orderDone(List<CartDTO> carts, OrderInfoDTO orderInfoDTO, String memberCd) {
		dao.ordItem(memberCd, carts);
		dao.ordInfo(memberCd, orderInfoDTO);
	}
	
	
	
	//페이징 처리를 위한 토탈카운트
	@Transactional
	public int totalCount(String memberCd) {
		return dao.totalCount(memberCd);
	}

	
	//주문 내역 기본화면
	@Transactional
	public List<OrderHistoryDTO> orderSearch(HashMap<String, String> map) {
		return dao.orderSearch(map);
	}

	//기간 주문 내역 조회
	@Transactional
	public List<OrderHistoryDTO> daySearch(HashMap<String, String> map) {
		return dao.daySearch(map);
	}

	//특정 아이템 내역 조회
	@Transactional
	public List<OrderHistoryDTO> itemSearch(HashMap<String, String> map) {
		return dao.itemSearch(map);
	}
	
}