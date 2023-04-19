package com.example.CartOrder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.CartOrder.dto.AmountUpdateDTO;
import com.example.CartOrder.dto.ArrayOptCdDTO;
import com.example.CartOrder.dto.CartConfirmDTO;
import com.example.CartOrder.dto.CartDTO;
import com.example.CartOrder.dto.SpecUpdateDTO;

@Mapper
public interface CartDAO {

	int cartAdd(CartDTO cart);

	int cartDelete(int cartCd);

	int checkDelete(int cartCd);

	int specUpdate(SpecUpdateDTO specUpdateDTO);

	int amountUpdate(AmountUpdateDTO amountUpdateDTO);



	List<ArrayOptCdDTO> typeSearch(Integer itCd);

	Integer cartTotal(String mbId);

	List<Integer> cartCdList(String mbId);

	List<CartConfirmDTO> cartList(String mbId);








}