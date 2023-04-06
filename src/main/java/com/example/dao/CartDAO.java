package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.CartDTO;

@Mapper
public interface CartDAO {

	int cartAdd(CartDTO cart);

	int cartDelete(int cartCd);

	int checkDelete(List<Integer> list);

	int specUpdate(HashMap<String, Integer> map);

	int amountUpdate(HashMap<String, Integer> map);

	
 
}