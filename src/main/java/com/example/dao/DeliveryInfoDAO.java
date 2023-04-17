package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UpTmDTO;

@Mapper
public interface DeliveryInfoDAO {
	void insertEndTm(UpTmDTO upTmDTO);
}