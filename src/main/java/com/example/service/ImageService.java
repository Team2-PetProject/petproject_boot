package com.example.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ImageDAO;
import com.example.dao.ItemDAO;
import com.example.dao.ItemListDAO;
import com.example.dto.ImageDTO;

@Service("ImageService")
public class ImageService {

	@Autowired
	private ImageDAO imageDao;
	@Autowired
	private ItemDAO itemDao;
	@Autowired
	private ItemListDAO itemListDao;
	
	@Transactional
	public int insertBoard(ImageDTO dto, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		int insertCount = imageDao.insertBoard(dto);
		System.out.println("insert 성공 : " + insertCount);
		map.put("img_cd", insertCount);
		int result1 = itemDao.insertItem(map);		
		
		return insertCount;
	}

	public ImageDTO findOne(int id) {
		ImageDTO dto = imageDao.findOne(id);
		return dto;
	}

	public void selectAll() {
		System.out.println();
	}

}
