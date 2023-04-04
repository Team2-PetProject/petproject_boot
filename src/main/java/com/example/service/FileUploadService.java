package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FileUploadDAO;
import com.example.dao.ItemDAO;
import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;

@Service
public class FileUploadService {
	@Autowired
	FileUploadDAO fileUploadDao;
	@Autowired
	ItemDAO itemDao;

	public void insertImgItem(FileUploadDTO fileUploadDTO, ItemDTO itemDTO) {
		fileUploadDao.insertFile(fileUploadDTO);
		int imgCd = fileUploadDTO.getImgCd();
		
		itemDTO.setImgCd(imgCd);
		itemDao.insertItem(itemDTO);
		
	}

	public FileUploadDTO findOne(Integer imgCd) {
		FileUploadDTO fileUploadDto = fileUploadDao.selectFile(imgCd);
		return fileUploadDto;
	}
	
}
