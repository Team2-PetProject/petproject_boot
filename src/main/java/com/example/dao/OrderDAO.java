package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.CartDTO;
import com.example.dto.CartOrdJoinDTO;
import com.example.dto.DeliveryInfoDTO;
import com.example.dto.OrderInfoDTO;
import com.example.dto.OrderSearchDTO;

@Mapper
public interface OrderDAO {

	void ordItem(String memberCd, List<CartDTO> carts);

	void ordInfo(String memberCd, OrderInfoDTO orderInfoDTO);

	int totalCount(String mbId);

	List<OrderSearchDTO> orderSearch(OrderSearchDTO orderSearchDTO);

	List<OrderSearchDTO> daySearch(OrderSearchDTO orderSearchDTO);

	List<OrderSearchDTO> itemSearch(OrderSearchDTO orderSearchDTO);

	DeliveryInfoDTO delevery(int dlvyCd);


	Integer fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO);

	List<CartOrdJoinDTO> cartOrdJoin(CartOrdJoinDTO cartOrdJoinDTO);


}
