package com.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.ImageDTO;

@Repository
public class ImageDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public int insertBoard(ImageDTO dto) {
		System.out.println("dao");
		int n = session.insert("insertBoard", dto);
		return dto.getId();
	}

	public ImageDTO findOne(int id) {
		return session.selectOne("findOne", id);
	}
	
}
