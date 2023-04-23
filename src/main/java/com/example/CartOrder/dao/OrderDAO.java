package com.example.CartOrder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.CartOrder.dto.CartDTO;
import com.example.CartOrder.dto.CartOrdDTO;
import com.example.CartOrder.dto.CartOrdJoinDTO;
import com.example.CartOrder.dto.CartSearchUnableDTO;
import com.example.CartOrder.dto.DeliveryInfoDTO;
import com.example.CartOrder.dto.OrderDoneDTO;
import com.example.CartOrder.dto.OrderInfoDTO;
import com.example.CartOrder.dto.OrderSearchDTO;

@Mapper
public interface OrderDAO {

	void ordItem(String memberCd, List<CartDTO> carts);

	Integer totalCount(String mbId);

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