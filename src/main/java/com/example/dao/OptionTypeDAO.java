package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.OptionTypeDTO;

@Mapper
public interface OptionTypeDAO {

	public void insertOptionType(OptionTypeDTO optionTypeDTO);

}
