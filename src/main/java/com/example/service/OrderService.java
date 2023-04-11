package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.common.SessionAttributeManager;
import com.example.dao.OrderDAO;
import com.example.dto.CartDTO;
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
	public List<OrderDoneDTO> orderDone(List<Integer> cartCd, OrderInfoDTO orderInfoDTO) {
//		String mbId=SessionAttributeManager.getMemberId();
		String mbId = "1";
		//배송장 번호 생성
		Integer inv = invRandom();
		DeliveryInfoDTO dlvyInfo = orderDao.dlvyInfo(inv);
		Integer dlvyCd = dlvyInfo.getDlvyCd();
		//오더인포 전보 전달s
		orderInfoDTO = orderDao.ordInfo(dlvyCd);

		//mp_cart
		Integer ordCd = orderInfoDTO.getOrdCd();

		//로그 심기
//		logger.info("dlvyCd: {}", dlvyCd);
		logger.info(dlvyCd);
		//

//		T_IT_CD이 문제임. ...
//		서버 갔다오면서 해결함 이거 문제있어보임.
		//I_IT_CD 구하기
		Integer seachCount = orderDao.seachCount();
		if (seachCount==0) {
			seachCount = 1;
		}
		Integer tItCd = seachCount+1;
		CartOrdDTO cartOrdDTO = new CartOrdDTO();
		cartOrdDTO.settItCd(tItCd);

		List<OrderDoneDTO> orderDoneLists = new ArrayList<OrderDoneDTO>();
		for ( Integer cd : cartCd ) {
			cartOrdDTO.setCartCd(cd);
			List<OrderDoneDTO> orderDoneList =	orderDao.orderDone(cartOrdDTO);
			orderDoneLists.addAll(orderDoneList);
		}
		return orderDoneLists;
	}

	
	
	//배송장번호 생성
	public Integer invRandom() {
		Integer minNum = 10000000; // 8자리 최소값
		Integer maxNum = 99999999; // 8자리 최대값
	    return ThreadLocalRandom.current().nextInt(minNum, maxNum + 1);
	}


}