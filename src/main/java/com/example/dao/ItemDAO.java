package com.example.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;

@Repository
public class ItemDAO {
	@Autowired
	SqlSessionTemplate session;

	public int insertItem(SqlSessionTemplate session, ItemDTO iDTO) {
//		return session.insert("insertItem", iDTO);
		return 1;
	}

	public int favoriteAdd(MemberItemDTO i_dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int favoriteDelete(String member_cd, int item_cd) {
		// TODO Auto-generated method stub
		return 0;
	}

}//end class
