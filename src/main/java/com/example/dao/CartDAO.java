package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.AmountUpdateDTO;
import com.example.dto.CartDTO;
import com.example.dto.SpecUpdateDTO;

@Mapper
public interface CartDAO {

	int cartAdd(CartDTO cart);

	int cartDelete(int cartCd);

	int checkDelete(int cartCd);

	int specUpdate(SpecUpdateDTO specUpdateDTO);

	int amountUpdate(AmountUpdateDTO amountUpdateDTO);



}