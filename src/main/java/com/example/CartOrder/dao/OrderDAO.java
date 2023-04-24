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
import com.example.CartOrder.dto.SearchResultDTO;

@Mapper
public interface OrderDAO {

	void ordItem(String memberCd, List<CartDTO> carts);

	Integer totalCount(String mbId);

	List<SearchResultDTO> orderSearch(OrderSearchDTO orderSearchDTO);

	List<SearchResultDTO> daySearch(OrderSearchDTO orderSearchDTO);

	Integer fastOrderConfirm(CartOrdJoinDTO cartOrdJoinDTO);

	List<CartOrdJoinDTO> cartOrdJoin(CartOrdJoinDTO cartOrdJoinDTO);

	Integer ordInfo(OrderInfoDTO orderInfoDTO);

	Integer dlvyInfo(DeliveryInfoDTO dlvyInfo);

	CartOrdJoinDTO cartOrdSet(Integer cartCd);

	List<OrderDoneDTO> orderDoneValueList(Integer itCd);

	Integer searchCount(String mbId);

	void orderDone(CartOrdDTO cartOrdDTO);

	void cartSearchUnable(CartSearchUnableDTO cartSearchUnableDTO);

	void updateTM(Integer dlvyCd);

	List<DeliveryInfoDTO> dlvyState(Integer dlvyCd);

	Integer dlvyCdMaxValue(Integer tItCd);

	Integer maxValueOrdCd();

}