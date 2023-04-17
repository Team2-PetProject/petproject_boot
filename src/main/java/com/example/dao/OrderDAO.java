package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.CartDTO;
import com.example.dto.CartOrdDTO;
import com.example.dto.CartOrdJoinDTO;
import com.example.dto.CartSearchUnableDTO;
import com.example.dto.DeliveryInfoDTO;
import com.example.dto.OrderDoneDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;

@Mapper
public interface OrderDAO {

	void ordItem(String memberCd, List<CartDTO> carts);

	int totalCount(String mbId);

	List<OrderSearchDTO> orderSearch(OrderSearchDTO orderSearchDTO);

	List<OrderSearchDTO> daySearch(OrderSearchDTO orderSearchDTO);

	Integer fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO);

	List<CartOrdJoinDTO> cartOrdJoin(CartOrdJoinDTO cartOrdJoinDTO);


	Integer ordInfo(OrderInfoDTO orderInfoDTO);


	Integer dlvyInfo(DeliveryInfoDTO dlvyInfo);


	CartOrdJoinDTO cartOrdSet(Integer cartCd);

	List<OrderDoneDTO> orderDoneValueList(Integer itCd);

	Integer searchCount();

	void orderDone(CartOrdDTO cartOrdDTO);

	void cartSearchUnable(CartSearchUnableDTO cartSearchUnableDTO);

	void updateTM(Integer dlvyCd);

	List<DeliveryInfoDTO> dlvyState(Integer dlvyCd);



}
