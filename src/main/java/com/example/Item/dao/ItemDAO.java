
package com.example.Item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.Item.dto.ItemDTO;
import com.example.Item.dto.ItemListDTO;
import com.example.admin.dto.ItemCdNmDTO;
import com.example.admin.dto.RegisterDTO;
import com.example.favorite.dto.MemberItemDTO;

@Mapper
public interface ItemDAO {

	public Integer totalCount(String cat);

	public Integer favoriteDelete(MemberItemDTO memberItemDTO);

	public void insertItem(ItemDTO itemDTO);

	public ItemDTO selectItem(Integer itCd);

	public void insertTyCd(RegisterDTO registerDto);

	public void updateItem(ItemDTO itemDto);

	public void deleteOptCd(Integer itCd);

	public List<ItemDTO> favoriteList(MemberItemDTO memberItemDTO);

	public Integer favoriteAdd(MemberItemDTO memberItemDTO);

	public List<ItemDTO> itemList(ItemListDTO itemList);

	public void deleteItem(Integer itCd);

	public Integer selectOptCd(Integer itCd);

	public Integer totalItem();

	public List<ItemCdNmDTO> adminList(ItemListDTO itemList);

	public Integer selectitInfoCd(Integer itCd);




}



