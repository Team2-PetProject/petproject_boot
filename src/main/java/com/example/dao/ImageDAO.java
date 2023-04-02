package com.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.ImageDTO;

@Repository
public class ImageDAO {

	public int insertBoard(SqlSessionTemplate session, ImageDTO dto) {
		System.out.println("dao");
		return session.insert("insertBoard", dto);
	}

	public ImageDTO findOne(SqlSessionTemplate session, int id) {
		return session.selectOne("findOne", id);
	}
	
}
