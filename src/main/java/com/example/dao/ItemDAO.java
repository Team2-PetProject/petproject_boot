package com.example.dao;


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;

@Repository
public class ItemDAO {

	public int insertItem(SqlSessionTemplate session, HashMap<String, Object> map) {
		System.out.println(map.get("list"));
		return session.insert("insertItems", map);
	}

}//end class
