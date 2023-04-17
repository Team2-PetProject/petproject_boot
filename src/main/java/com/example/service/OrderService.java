package com.example.service;

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
import com.example.dto.CartSearchUnableDTO;
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



	// 주문결제화면 정보넘기기위한 join문
	@Transactional
	public List<CartOrdJoinDTO> cartOrdJoin(CartOrdJoinDTO cartOrdJoinDTO) {
		return orderDao.cartOrdJoin(cartOrdJoinDTO);
	}

	@Transactional
	public List<OrderDoneDTO> orderDone(List<Integer> cartCds, OrderInfoDTO orderInfoDTO) {
//		String mbId=SessionAttributeManager.getMemberId();
		String mbId = "1";
		Integer inv = invRandom();
		DeliveryInfoDTO dlvyInfo = new DeliveryInfoDTO();
		dlvyInfo.setInv(inv);
		Integer dlvyCd = orderDao.dlvyInfo(dlvyInfo);
		orderInfoDTO.setDlvyCd(dlvyCd);
		Integer ordCd = orderDao.ordInfo(orderInfoDTO);
		logger.info(dlvyCd+" ||");
		Integer searchCountTItCd = orderDao.searchCount();
		if (searchCountTItCd == null) {
			searchCountTItCd = 0;
		}
		Integer tItCd = searchCountTItCd + 1;
		CartOrdDTO cartOrdDTO = new CartOrdDTO();
		cartOrdDTO.settItCd(tItCd);
		cartOrdDTO.setOrdCd(ordCd);
		cartOrdDTO.setMbId(mbId);
		CartOrdJoinDTO cartOrdSet = new CartOrdJoinDTO();
		for (Integer cartCd : cartCds) {
			cartOrdSet = orderDao.cartOrdSet(cartCd);
			cartOrdDTO.setCartCd(cartCd);
			cartOrdDTO.setItCd(cartOrdSet.getItCd());
			cartOrdDTO.setAmount(cartOrdSet.getAmount());
			cartOrdDTO.setPrice(cartOrdSet.getPrice());
			cartOrdDTO.setImgCd(cartOrdSet.getImgCd());
			cartOrdDTO.setOptCd(cartOrdSet.getOptCd());
			orderDao.orderDone(cartOrdDTO);
		}
		CartSearchUnableDTO cartSearchUnableDTO = new CartSearchUnableDTO();
		cartSearchUnableDTO.setMbId(mbId);
		for (Integer cartCd : cartCds) {
			cartSearchUnableDTO.setCartCd(cartCd);
			orderDao.cartSearchUnable(cartSearchUnableDTO);

		}
		if (dlvyCd>1) {
			dlvyCd=dlvyCd-1;
		}
		orderDao.updateTM(dlvyCd);
		List<OrderDoneDTO> valueList = orderDao.orderDoneValueList(tItCd);
		return valueList;
	}

	// 주문 내역 기본화면
	@Transactional
	public List<OrderSearchDTO> orderSearch(OrderSearchDTO orderSearchDTO) {
		System.err.println(orderSearchDTO);
		return orderDao.orderSearch(orderSearchDTO);
	}

	// 기간 주문 내역 조회
	@Transactional
	public List<OrderSearchDTO> daySearch(OrderSearchDTO orderSearchDTO) {
		return orderDao.daySearch(orderSearchDTO);
	}


	// 배송장번호 생성
	public Integer invRandom() {
		Integer minNum = 10000000; // 8자리 최소값
		Integer maxNum = 99999999; // 8자리 최대값
		return ThreadLocalRandom.current().nextInt(minNum, maxNum + 1);
	}
	// 페이징 처리를 위한 토탈카운트
		@Transactional
		public int totalCount(String mbId) {
			return orderDao.totalCount(mbId);
		}



		public List<DeliveryInfoDTO> dlvyState(Integer dlvyCd) {
			return orderDao.dlvyState(dlvyCd);
		}


}