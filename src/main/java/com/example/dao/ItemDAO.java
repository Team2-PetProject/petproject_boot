package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;

@Mapper
public interface ItemDAO {

	public int favoriteAdd(MemberItemDTO memberItemDTO);

	public int favoriteDelete(MemberItemDTO memberItemDTO);

	public void insertItem(ItemDTO itemDTO);

	public ItemDTO selectItem(Integer itCd);
	
}
