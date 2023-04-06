package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.CartDTO;
import com.example.dto.OrderHistoryDTO;
import com.example.dto.OrderInfoDTO;

@Mapper
public interface OrderDAO {

	void ordItem(String memberCd, List<CartDTO> carts);

	void ordInfo(String memberCd, OrderInfoDTO orderInfoDTO);

	int totalCount(String memberCd);

	List<OrderHistoryDTO> orderSearch(HashMap<String, String> map);

	List<OrderHistoryDTO> daySearch(HashMap<String, String> map);

	List<OrderHistoryDTO> itemSearch(HashMap<String, String> map);

}
