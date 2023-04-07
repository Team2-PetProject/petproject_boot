package com.example.daoImpl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;

@Repository
public class ItemDAOImpl {
	@Autowired
	SqlSessionTemplate session;

	public int insertItem(SqlSessionTemplate session, ItemDTO iDTO) {
//		return session.insert("insertItem", iDTO);
		return 1;
	}


	public int favoriteDelete(String member_cd, int item_cd) {
		// TODO Auto-generated method stub
		return 0;
	}

}//end class
