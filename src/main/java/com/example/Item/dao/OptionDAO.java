package com.example.Item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.Item.dto.OptionDTO;

@Mapper
public interface OptionDAO {

	public List<String> selectOption(Integer tyCd);

	public void insertOption(OptionDTO optionDTO);

	public Integer selectTyCd(Integer optCd);

	public void deleteOption(Integer tyCd);

}