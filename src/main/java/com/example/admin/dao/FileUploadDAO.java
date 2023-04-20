package com.example.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.admin.dto.FileUploadDTO;
import com.example.admin.dto.ItemInfoDTO;

@Mapper
public interface FileUploadDAO {

	public int insertFile(FileUploadDTO fileUploadDTO);

	public FileUploadDTO selectFile(Integer imgCd);

	public void updateFile(FileUploadDTO fileUploadDTO);

	public void insertInfoFile(ItemInfoDTO itemInfoDTO);

	public ItemInfoDTO selectDetailFile(int imgCd);

	public void updateDetailFile(ItemInfoDTO itemInfoDTO);

	public void deleteFile(Integer imgCd);

	public void deleteDetailFile(Integer itCd);

}