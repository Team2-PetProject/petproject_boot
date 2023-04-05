package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.MemberItemDTO;

@Mapper
public interface ItemDAO {

	public int favoriteAdd(MemberItemDTO i_dto);

	public int favoriteDelete(String member_cd, int item_cd);
	
	
}
