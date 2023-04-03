package com.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.FileUploadDTO;

@Repository
public class ImageDAO {


	public FileUploadDTO findOne(SqlSessionTemplate session, Integer id) {
		return session.selectOne("findOne", id);
	}

	public int insertFile(SqlSessionTemplate session, FileUploadDTO fileUploadDTO) {
		int imgCd = session.insert("insertFile", fileUploadDTO);
		return fileUploadDTO.getImgCd();
	}
	
}
