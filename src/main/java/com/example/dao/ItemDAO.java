package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.ItemDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.MemberItemDTO;
import com.example.dto.RegisterDTO;

@Mapper
public interface ItemDAO {

	public Integer totalCount(String cat);

	public int favoriteDelete(MemberItemDTO memberItemDTO);

	public void insertItem(ItemDTO itemDTO);

	public ItemDTO selectItem(Integer itCd);

	public void insertTyCd(RegisterDTO registerDto);

	public void updateItem(ItemDTO itemDto);

	public void deleteOptCd(Integer itCd);

	public List<ItemDTO> favoriteList(MemberItemDTO memberItemDTO);

	public Integer favoriteAdd(MemberItemDTO memberItemDTO);

	public List<ItemDTO> itemList(ItemListDTO itemList);




}



