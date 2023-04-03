package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.daoimpl.ImageDAOImpl;
import com.example.daoimpl.ItemDAOImpl;
import com.example.daoimpl.ItemListDAOImpl;
import com.example.dto.ImageDTO;
import com.example.dto.ItemDTO;

@Service("ImageService")
public class ImageService {

	@Autowired
	ImageDAOImpl dao;
	@Autowired
	ItemDAOImpl iDAO;
	@Autowired
	ItemListDAOImpl lDAO;
	@Autowired
	SqlSessionTemplate session;
	
	@Transactional
	public int insertBoard(ImageDTO dto, ItemDTO iDTO) {
		// TODO Auto-generated method stub
		int n = dao.insertBoard(session, dto);
		System.out.println("insert 성공 : " + n);
		int result1 = lDAO.insertList(session, iDTO);
		int result2 = iDAO.insertItem(session, iDTO);
		
		return n;
	}

	public ImageDTO findOne(int id) {
		ImageDTO dto = dao.findOne(session, id);
		return dto;
	}

	public void selectAll() {
		System.out.println(session);
	}

}
