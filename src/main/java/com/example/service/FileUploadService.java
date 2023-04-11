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
	public void insertImgItemOpt(FileUploadDTO fileUploadDTO, List<ItemDTO> itemList, String optionName,
			List<OptionDTO> optionList) {
		fileUploadDao.insertFile(fileUploadDTO);
		int imgCd = fileUploadDTO.getImgCd();
		Integer tyCd = optionTypeDao.selectTyCd();
		for(int i=0;i<itemList.size();i++) {
			ItemDTO itemDto = itemList.get(i);
			itemDto.setImgCd(imgCd);
			itemDao.insertItem(itemDto);
			Integer itCd = itemDto.getItCd();
			Integer optCd = itemDto.getOptCd();
			OptionTypeDTO optionTypeDto = new OptionTypeDTO();
			optionTypeDto.setTyNm(optionName);
			optionTypeDto.setItCd(itCd);
			optionTypeDto.setTyCd(tyCd);
			optionTypeDao.insertOptionType(optionTypeDto);
			OptionDTO optionDto = new OptionDTO();
			optionDto.setOptNm(optionList.get(i).getOptNm());
			optionDto.setTyCd(tyCd);
			optionDto.setOptCd(optCd);
			optionDao.insertOption(optionDto);
		}
	}
	
	
}
