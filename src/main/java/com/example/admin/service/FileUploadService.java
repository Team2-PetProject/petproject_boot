package com.example.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Item.dao.ItemDAO;
import com.example.Item.dao.OptionDAO;
import com.example.Item.dao.OptionTypeDAO;
import com.example.Item.dto.ItemDTO;
import com.example.Item.dto.OptionDTO;
import com.example.Item.dto.OptionTypeDTO;
import com.example.admin.dao.FileUploadDAO;
import com.example.admin.dto.FileUploadDTO;
import com.example.admin.dto.ItemInfoDTO;
import com.example.admin.dto.RegisterDTO;

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
	public void insertImgItem(FileUploadDTO fileUploadDTO, ItemInfoDTO itemInfoDTO, ItemDTO itemDTO) {
		fileUploadDao.insertFile(fileUploadDTO);
		int imgCd = fileUploadDTO.getImgCd();
		itemDTO.setImgCd(imgCd);
		itemDao.insertItem(itemDTO);
		Integer itCd = itemDTO.getItCd();
		itemInfoDTO.setItCd(itCd);
		fileUploadDao.insertInfoFile(itemInfoDTO);
	}
	
	@Transactional
	public FileUploadDTO findOne(Integer imgCd) {
		FileUploadDTO fileUploadDto = fileUploadDao.selectFile(imgCd);
		return fileUploadDto;
	}
	
	@Transactional
	public void insertImgItemOpt(FileUploadDTO fileUploadDTO, ItemInfoDTO itemInfoDTO, ItemDTO itemDto, String optionName,
			List<OptionDTO> optionList) {
		fileUploadDao.insertFile(fileUploadDTO);
		int imgCd = fileUploadDTO.getImgCd();
		Integer tyCd = optionTypeDao.selectTyCd();
		itemDto.setImgCd(imgCd);
		itemDao.insertItem(itemDto);
		Integer itCd = itemDto.getItCd();
		itemInfoDTO.setItCd(itCd);
		fileUploadDao.insertInfoFile(itemInfoDTO);
		
		OptionTypeDTO optionTypeDto = new OptionTypeDTO();
		optionTypeDto.setTyNm(optionName);
		optionTypeDto.setItCd(itCd);
		optionTypeDto.setTyCd(tyCd);
		optionTypeDao.insertOptionType(optionTypeDto);
		System.out.println(optionTypeDto.getTyCd());
		
		Integer optCd = null;
		for(int i=0;i<optionList.size();i++) {
			OptionDTO optionDto = new OptionDTO();
			optionDto.setOptNm(optionList.get(i).getOptNm());
			optionDto.setTyCd(optionTypeDto.getTyCd());
			optionDao.insertOption(optionDto);
			optCd = optionDto.getOptCd();
		}
		RegisterDTO registerDto = new RegisterDTO();
		registerDto.setItCd(itCd);
		registerDto.setOptCd(optCd);
		itemDao.insertTyCd(registerDto);
	}

	@Transactional
	public void updateImgItemOpt(FileUploadDTO fileUploadDTO, ItemInfoDTO itemInfoDTO, ItemDTO itemDto, String optionName,
			List<OptionDTO> optionList) {
		if(fileUploadDTO.getImgCd() != null) {
			fileUploadDao.updateFile(fileUploadDTO);
		}
		if(itemInfoDTO.getItInfoCd()!=null) {
			fileUploadDao.updateDetailFile(itemInfoDTO);
		}
		if(itemDto.getOptCd()!=null) {
			Integer tyCd = optionDao.selectTyCd(itemDto.getOptCd());
			optionDao.deleteOption(tyCd);
			optionTypeDao.deleteType(tyCd);
			itemDao.deleteOptCd(itemDto.getItCd());
		}
		Integer tyCd = optionTypeDao.selectTyCd();
		itemDao.updateItem(itemDto);
		
		OptionTypeDTO optionTypeDto = new OptionTypeDTO();
		optionTypeDto.setTyNm(optionName);
		optionTypeDto.setItCd(itemDto.getItCd());
		optionTypeDto.setTyCd(tyCd);
		optionTypeDao.insertOptionType(optionTypeDto);
		Integer optCd = null;
		for(int i=0;i<optionList.size();i++) {
			OptionDTO optionDto = new OptionDTO();
			optionDto.setOptNm(optionList.get(i).getOptNm());
			optionDto.setTyCd(optionTypeDto.getTyCd());
			optionDao.insertOption(optionDto);
			optCd = optionDto.getOptCd();
		}
		RegisterDTO registerDto = new RegisterDTO();
		registerDto.setItCd(itemDto.getItCd());
		registerDto.setOptCd(optCd);
		itemDao.insertTyCd(registerDto);
	}

	@Transactional
	public void updateImgItem(FileUploadDTO fileUploadDTO, ItemInfoDTO itemInfoDTO, ItemDTO itemDTO) {
		if(fileUploadDTO.getImgCd() != null) {
			fileUploadDao.updateFile(fileUploadDTO);
		}
		if(itemInfoDTO.getItInfoCd()!=null) {
			fileUploadDao.updateDetailFile(itemInfoDTO);
		}
		if(itemDTO.getOptCd() !=null) {
			Integer tyCd = optionDao.selectTyCd(itemDTO.getOptCd());
			optionDao.deleteOption(tyCd);
			optionTypeDao.deleteType(tyCd);
			itemDao.deleteOptCd(itemDTO.getItCd());
		}
		itemDao.updateItem(itemDTO);
	}

	public ItemInfoDTO findDetail(int imgCd) {
		ItemInfoDTO itemInfoDto = fileUploadDao.selectDetailFile(imgCd);
		return itemInfoDto;
	}

	public void deleteFile(Integer imgCd, Integer itCd) {
		fileUploadDao.deleteFile(imgCd);
		fileUploadDao.deleteDetailFile(itCd);
	}
	
	
}