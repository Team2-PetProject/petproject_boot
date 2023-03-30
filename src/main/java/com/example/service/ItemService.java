package com.example.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ItemDAO;
import com.example.dto.CartDTO;
import com.example.dto.ItemDTO;
import com.example.dto.ItemFavoriteDTO;
import com.example.dto.ItemListDTO;

@Service("ItemService")
public class ItemService {
	@Autowired
	ItemDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	public List<ItemListDTO> itemList(String item_cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemDTO detail(String item_cd) {
		// TODO Auto-generated method stub
		return null;
	}




	
}//end class

