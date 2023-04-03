package com.example.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ItemDAO;
import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;
import com.example.dto.OptionDTO;

@Service("itemService")
public class ItemService {
	@Autowired
	ItemDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	public List<OptionDTO> itemList(String item_cat) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemDTO detail(String item_cd) {
		// TODO Auto-generated method stub
		return null;
	}

	public int favoriteAdd(MemberItemDTO i_dto) {
		return dao.favoriteAdd(i_dto);
	}

	public int favoriteDelete(String member_cd, int item_cd) {
		return dao.favoriteDelete(member_cd,item_cd);
	}




	
}//end class
