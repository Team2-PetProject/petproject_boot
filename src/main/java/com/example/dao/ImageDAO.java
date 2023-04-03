package com.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.FileUploadDTO;

@Repository
public class ImageDAO {

	public int insertBoard(SqlSessionTemplate session, FileUploadDTO dto) {
		System.out.println("dao");
		return session.insert("insertBoard", dto);
	}

	public FileUploadDTO findOne(SqlSessionTemplate session, Integer id) {
		return session.selectOne("findOne", id);
	}
	
}
