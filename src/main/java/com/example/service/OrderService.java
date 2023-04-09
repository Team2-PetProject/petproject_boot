package com.example.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.SessionAttributeManager;
import com.example.controller.OrderController;
import com.example.dao.OrderDAO;
import com.example.dto.CartDTO;
import com.example.dto.DeliveryInfoDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;

@Service
public class OrderService {
	@Autowired
	OrderDAO orderDao;

	private static final Logger logger = LogManager.getLogger(OrderService.class);

	@Transactional
	public void orderDone(List<CartDTO> carts, OrderInfoDTO orderInfoDTO, String mbId) {
		orderDao.ordItem(mbId, carts);
		orderDao.ordInfo(mbId, orderInfoDTO);
	}

	//페이징 처리를 위한 토탈카운트
	@Transactional
	public int totalCount(String mbId) {
		return orderDao.totalCount(mbId);
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

	//배송조회
	@Transactional
	public DeliveryInfoDTO delevery(int dlvyCd) {
		 logger.info("", dlvyCd);
		return orderDao.delevery(dlvyCd);
	}



}