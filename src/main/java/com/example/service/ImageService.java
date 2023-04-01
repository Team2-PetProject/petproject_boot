package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ImageDAO;
import com.example.dao.ItemDAO;
import com.example.dao.ItemListDAO;
import com.example.dto.ImageDTO;
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
	public int insertBoard(ImageDTO dto, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		int n = dao.insertBoard(session, dto);
		System.out.println("insert 성공 : " + n);
		map.put("img_cd", n);
		int result1 = iDAO.insertItem(session, map);		
		
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
