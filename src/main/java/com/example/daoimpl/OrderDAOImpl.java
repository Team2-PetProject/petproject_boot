package com.example.daoimpl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.CartDTO;
import com.example.dto.OrderHistoryDTO;
import com.example.dto.OrderInfoDTO;
//data access object 데이터 접근 물체
@Repository
public class OrderDAOImpl {
	@Autowired
	SqlSessionTemplate session;
	
	
	public void ordItem(String member_cd, List<CartDTO> carts) {
		// TODO Auto-generated method stub
		
	}

	public void ordInfo(String member_cd, OrderInfoDTO info) {
		// TODO Auto-generated method stub
		
	}

	public int totalCount(String member_cd) {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<OrderHistoryDTO> orderSearch(HashMap<String, String> map) {
		return null;
	}


	public List<OrderHistoryDTO> itemSearch(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderHistoryDTO> daySearch(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
