package com.example.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;

@Repository
public class ItemDAO {
	
	@Autowired
	private SqlSessionTemplate session;

	public int favoriteAdd(MemberItemDTO i_dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int favoriteDelete(String member_cd, int item_cd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void insertItem(SqlSessionTemplate session2, ItemDTO itemDTO) {
		session.insert("insertItem", itemDTO);
	}

}//end class
