package com.example.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;

@Repository
public class ItemDAO {

	public int insertItem(SqlSessionTemplate session, List<ItemDTO> list) {
		return session.insert("insertItems", list);
	}

}//end class
