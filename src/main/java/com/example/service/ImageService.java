package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ImageDAO;
import com.example.dao.ItemDAO;
import com.example.dao.ItemListDAO;
import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;

@Service("ImageService")
public class ImageService {

	@Autowired
	ImageDAO dao;
	@Autowired
	ItemDAO iDAO;
	@Autowired
	ItemListDAO lDAO;
	@Autowired
	SqlSessionTemplate session;
	
	@Transactional
	public int insertBoard(FileUploadDTO dto, ItemDTO iDTO) {
		// TODO Auto-generated method stub
		int n = dao.insertBoard(session, dto);
		System.out.println("insert 성공 : " + n);
		int result1 = lDAO.insertList(session, iDTO);
		int result2 = iDAO.insertItem(session, iDTO);
		
		return n;
	}

	public FileUploadDTO findOne(int id) {
		FileUploadDTO dto = dao.findOne(session, id);
		return dto;
	}

	public void selectAll() {
		System.out.println(session);
	}

}
