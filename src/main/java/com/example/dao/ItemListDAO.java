package com.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.ItemDTO;

@Repository
public class ItemListDAO {

	public int insertList(SqlSessionTemplate session, ItemDTO iDTO) {
		return session.insert("insertList", iDTO);
	}

}
