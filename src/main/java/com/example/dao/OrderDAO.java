package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.CartDTO;
import com.example.dto.CartOrdDTO;
import com.example.dto.CartOrdJoinDTO;
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

	List<OrderSearchDTO> itemSearch(OrderSearchDTO orderSearchDTO);

	Integer fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO);

	List<CartOrdJoinDTO> cartOrdJoin(CartOrdJoinDTO cartOrdJoinDTO);

	DeliveryInfoDTO dlvyInfo(Integer inv);

	OrderInfoDTO ordInfo(Integer dlvyCd);

	Integer seachCount();

	List<OrderDoneDTO> orderDone(CartOrdDTO cartOrdDTO);

}