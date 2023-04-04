package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.OptionDTO;

@Mapper
public interface OptionDAO {

	public void insertOptions(List<OptionDTO> optionList);

}
