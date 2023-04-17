package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.OptionTypeDTO;
import com.example.dto.TypeDTO;

@Mapper
public interface OptionTypeDAO {

	public void insertOptionType(OptionTypeDTO optionTypeDTO);

	public TypeDTO selectType(Integer itCd);

	public Integer selectTyCd();

	public void deleteType(Integer tyCd);

}
