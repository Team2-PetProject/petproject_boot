package com.example.Item.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.Item.dto.OptionTypeDTO;
import com.example.Item.dto.TypeDTO;

@Mapper
public interface OptionTypeDAO {

	public void insertOptionType(OptionTypeDTO optionTypeDTO);

	public TypeDTO selectType(Integer itCd);

	public Integer selectTyCd();

	public void deleteType(Integer tyCd);

}