package com.example.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;

@Repository
public class ItemDAO {

	public int insertItem(SqlSessionTemplate session, ItemDTO iDTO) {
//		return session.insert("insertItem", iDTO);
		return 1;
	}

}//end class
