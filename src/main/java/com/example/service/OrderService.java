package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.OrderHistoryDAO;
import com.example.dto.CartDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;

@Service
public class OrderService {
	@Autowired
	OrderHistoryDAO orderDao;

	
	@Transactional
	public void orderDone(List<CartDTO> carts, OrderInfoDTO orderInfoDTO, String memberCd) {
		orderDao.ordItem(memberCd, carts);
		orderDao.ordInfo(memberCd, orderInfoDTO);
		//TO:DO insert dlvy sta 
		//start time == orderDone
		//end time  == 
		
		
	}
	
	//페이징 처리를 위한 토탈카운트
	@Transactional
	public int totalCount(String memberCd) {
		return orderDao.totalCount(memberCd);
	}

	
	//주문 내역 기본화면
	@Transactional
	public List<OrderSearchDTO> orderSearch(OrderSearchDTO orderSearchDTO) {
		return orderDao.orderSearch(orderSearchDTO);
	}

	//기간 주문 내역 조회
	@Transactional
	public List<OrderSearchDTO> daySearch(OrderSearchDTO orderSearchDTO) {
		return orderDao.daySearch(orderSearchDTO);
	}

	//특정 아이템 내역 조회
	@Transactional
	public List<OrderSearchDTO> itemSearch(OrderSearchDTO orderSearchDTO) {
		return orderDao.itemSearch(orderSearchDTO);
	}

}