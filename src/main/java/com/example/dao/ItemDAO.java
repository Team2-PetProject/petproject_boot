package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;
import com.example.dto.RegisterDTO;

@Mapper
public interface ItemDAO {

	public int favoriteAdd(MemberItemDTO memberItemDTO);

	public int favoriteDelete(MemberItemDTO memberItemDTO);

	public void insertItem(ItemDTO itemDTO);

	public ItemDTO selectItem(Integer itCd);

	public void insertTyCd(RegisterDTO registerDto);

	public int totalCount();

	public List<ItemDTO> itemList(String cat);

	public List<ItemDTO> favoriteList(MemberItemDTO memberItemDTO);

	public List<ItemDTO> mbFavoriteList(String mbId);
}



