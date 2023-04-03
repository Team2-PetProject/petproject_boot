package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ImageDAO;
import com.example.dao.ItemDAO;
import com.example.dao.ItemListDAO;
import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;


@Service("ImageService")
public class ImageService {

	@Autowired
	private ImageDAO imageDao;
	@Autowired
	private ItemDAO itemDao;
	@Autowired
	private SqlSessionTemplate session;
	
	
	public FileUploadDTO findOne(int id) {
		FileUploadDTO dto = imageDao.findOne(session, id);
		return dto;
	}

	public void selectAll() {
		System.out.println();
	}

	public void insertImgItem(FileUploadDTO fileUploadDTO, ItemDTO itemDTO) {
		int imgCd = imageDao.insertFile(session, fileUploadDTO);
		
		itemDTO.setImgCd(imgCd);
		itemDao.insertItem(session, itemDTO);	
		
	}


}
