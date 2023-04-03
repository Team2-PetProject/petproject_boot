package com.example.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemListDAO {

	public int insertList(SqlSessionTemplate session, HashMap<String, Object> map) {
		return session.insert("insertList", map);
	}

}
