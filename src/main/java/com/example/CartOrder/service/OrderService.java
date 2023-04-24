package com.example.CartOrder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CartOrder.dao.OrderDAO;
import com.example.CartOrder.dto.CartOrdDTO;
import com.example.CartOrder.dto.CartOrdJoinDTO;
import com.example.CartOrder.dto.CartSearchUnableDTO;
import com.example.CartOrder.dto.DeliveryInfoDTO;
import com.example.CartOrder.dto.OrderDoneDTO;
import com.example.CartOrder.dto.OrderInfoDTO;
import com.example.CartOrder.dto.OrderSearchDTO;
import com.example.CartOrder.dto.SearchResultDTO;
import com.example.common.SessionAttributeManager;

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
		String mbId = SessionAttributeManager.getMemberId();
		DeliveryInfoDTO dlvyInfo = new DeliveryInfoDTO();

		Integer dlvyCd;
		Integer inv = invRandom();
		Integer searchCountTItCd = orderDao.searchCount(mbId);
		Integer maxOrdCd = orderDao.maxValueOrdCd();
		if (maxOrdCd!=0) {
			orderInfoDTO.setOrdCd(maxOrdCd + 1);
		} else if (maxOrdCd==0) {
			orderInfoDTO.setOrdCd(maxOrdCd);
		} else {
			logger.info("maxOrdCd Value" + maxOrdCd + "OrderInfoDTO : " +orderInfoDTO);
		}


		if (searchCountTItCd == null || searchCountTItCd == 0) {
			searchCountTItCd = 1;
		}

		Integer tItCd = searchCountTItCd + 1;

		List<Integer> dlvyCds = new ArrayList<Integer>();
		for (int i = 0; i < cartCds.size(); i++) {
			inv = inv + i;
			dlvyInfo.setInv(inv);
			dlvyCd = orderDao.dlvyInfo(dlvyInfo);
			logger.info(dlvyCd + " ||");
			orderInfoDTO.setDlvyCd(dlvyInfo.getDlvyCd());
			orderDao.ordInfo(orderInfoDTO);
			dlvyCds.add(dlvyCd);
		}
		Integer ordCd = orderInfoDTO.getOrdCd();
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
		if (dlvyCds.size()!=0) {
			for (Integer upDateDlvyCd : dlvyCds) {
				if (upDateDlvyCd>0 ) {
					orderDao.updateTM(upDateDlvyCd);
				}else {
					logger.error("upDateDlvyCd Value" + upDateDlvyCd);
				}
			}
		}
		List<OrderDoneDTO> valueList = orderDao.orderDoneValueList(tItCd);
		return valueList;
	}

	// 주문 내역 기본화면
	@Transactional
	public List<SearchResultDTO> orderSearch(OrderSearchDTO orderSearchDTO) {
		return orderDao.orderSearch(orderSearchDTO);
	}

	// 기간 주문 내역 조회
	@Transactional
	public List<SearchResultDTO> daySearch(OrderSearchDTO orderSearchDTO) {
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

	@Transactional
	public List<DeliveryInfoDTO> dlvyState(Integer dlvyCd) {
		return orderDao.dlvyState(dlvyCd);
	}

}