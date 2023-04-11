package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.OrderDAO;
import com.example.dto.CartOrdDTO;
import com.example.dto.CartOrdJoinDTO;
import com.example.dto.DeliveryInfoDTO;
import com.example.dto.OrderDoneDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;

@Service
public class OrderService {
	@Autowired
	OrderDAO orderDao;

	private static final Logger logger = LogManager.getLogger(OrderService.class);

	@Transactional
	public Integer fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO) {
		return orderDao.fastOrderConfirm(cartOrdJoinDTO);
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

	//주문결제화면 정보넘기기위한 join문
	@Transactional
	public List<CartOrdJoinDTO> cartOrdJoin(CartOrdJoinDTO cartOrdJoinDTO) {
		return orderDao.cartOrdJoin(cartOrdJoinDTO);
	}

	@Transactional
	public List<CartOrdDTO> orderDone(List<Integer> cartCds, OrderInfoDTO orderInfoDTO) {
//		String mbId=SessionAttributeManager.getMemberId();
		String mbId = "PET";
		Integer inv = invRandom();
		System.err.println(inv);
		DeliveryInfoDTO dlvyInfo = new DeliveryInfoDTO();
		dlvyInfo.setInv(inv);
		Integer dlvyCd =orderDao.dlvyInfo(dlvyInfo);
		orderInfoDTO.setDlvyCd(dlvyCd);
//		Integer ordCd = orderDao.ordInfo(orderInfoDTO);
		Integer ordCd = 2;
		System.err.println("ordCd"+ordCd);
		logger.info(dlvyCd);

		Integer seachCountTItCd = orderDao.seachCount();
		if (seachCountTItCd==0) {
			seachCountTItCd = 1;
		}
		Integer tItCd = seachCountTItCd+1;
		CartOrdDTO cartOrdDTO = new CartOrdDTO();
		cartOrdDTO.settItCd(tItCd);
		cartOrdDTO.setOrdCd(ordCd);
		cartOrdDTO.setMbId(mbId);
		CartOrdJoinDTO cartOrdSet = new CartOrdJoinDTO();
		for ( Integer cartCd : cartCds ) {
			cartOrdSet = orderDao.cartOrdSet(cartCd);
			cartOrdDTO.setCartCd(cartCd);
			cartOrdDTO.setItCd(cartOrdSet.getItCd());
			cartOrdDTO.setAmount(cartOrdSet.getAmount());
			cartOrdDTO.setPrice(cartOrdSet.getPrice());
			cartOrdDTO.setImgCd(cartOrdSet.getImgCd());
			cartOrdDTO.setOptCd(cartOrdSet.getOptCd());
			orderDao.orderDone(cartOrdDTO);
		}
//		orderDao.cartOrdSet();
		List<OrderDoneDTO> orderDoneLists = new ArrayList<OrderDoneDTO>();


		return null;
	}



	//배송장번호 생성
	public Integer invRandom() {
		Integer minNum = 10000000; // 8자리 최소값
		Integer maxNum = 99999999; // 8자리 최대값
	    return ThreadLocalRandom.current().nextInt(minNum, maxNum + 1);
	}


}