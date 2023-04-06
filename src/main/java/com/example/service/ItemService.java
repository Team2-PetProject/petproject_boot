package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ItemDAO;
import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;
import com.example.dto.OptionDTO;

@Service
public class ItemService {
	@Autowired
	ItemDAO itemDao;
	
	public List<OptionDTO> itemList(String item_cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemDTO detail(String item_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	public int favoriteAdd(MemberItemDTO memberItemDTO) {
		return itemDao.favoriteAdd(memberItemDTO);
	}

	public int favoriteDelete(MemberItemDTO memberItemDTO) {
		return itemDao.favoriteDelete(memberItemDTO);
	}
	
}//end class
