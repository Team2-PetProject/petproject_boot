package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.FileUploadDAO;
import com.example.dao.ItemDAO;
import com.example.dao.OptionDAO;
import com.example.dao.OptionTypeDAO;
import com.example.dto.FileUploadDTO;
import com.example.dto.ItemDTO;
import com.example.dto.OptionDTO;
import com.example.dto.OptionTypeDTO;
import com.example.dto.RegisterDTO;

@Service
public class FileUploadService {
	@Autowired
	FileUploadDAO fileUploadDao;
	@Autowired
	ItemDAO itemDao;
	@Autowired
	OptionTypeDAO optionTypeDao;
	@Autowired
	OptionDAO optionDao;

	@Transactional
	public void insertImgItem(FileUploadDTO fileUploadDTO, ItemDTO itemDTO) {
		fileUploadDao.insertFile(fileUploadDTO);
		int imgCd = fileUploadDTO.getImgCd();
		
		itemDTO.setImgCd(imgCd);
		itemDao.insertItem(itemDTO);
	}
	
	@Transactional
	public FileUploadDTO findOne(Integer imgCd) {
		FileUploadDTO fileUploadDto = fileUploadDao.selectFile(imgCd);
		return fileUploadDto;
	}
	
	@Transactional
	public void insertImgItemOpt(FileUploadDTO fileUploadDTO, ItemDTO itemDTO, OptionTypeDTO optionTypeDTO,
			List<OptionDTO> optionList) {
		fileUploadDao.insertFile(fileUploadDTO);
		int imgCd = fileUploadDTO.getImgCd();
		
		itemDTO.setImgCd(imgCd);
		itemDao.insertItem(itemDTO);
		
		Integer itCd = itemDTO.getItCd();
		optionTypeDTO.setItCd(itCd);
		
		optionTypeDao.insertOptionType(optionTypeDTO);
		Integer tyCd = optionTypeDTO.getTyCd();
		
		RegisterDTO registerDto = new RegisterDTO();
		registerDto.setItCd(itCd);
		registerDto.setTyCd(tyCd);
		itemDao.insertTyCd(registerDto);
		
		for (int i = 0; i < optionList.size(); i++) {
			optionList.get(i).setTyCd(tyCd);
		}
		optionDao.insertOptions(optionList);
	}
	
	
}
