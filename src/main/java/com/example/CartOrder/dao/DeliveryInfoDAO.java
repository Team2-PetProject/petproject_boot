package com.example.CartOrder.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.CartOrder.dto.UpTmDTO;

@Mapper
public interface DeliveryInfoDAO {

	void insertEndTm(UpTmDTO upTmDTO);
}