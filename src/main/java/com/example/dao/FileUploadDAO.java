package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.FileUploadDTO;

@Mapper
public interface FileUploadDAO {

	public int insertFile(FileUploadDTO fileUploadDTO);

	public FileUploadDTO selectFile(Integer imgCd);

	public void updateFile(FileUploadDTO fileUploadDTO);

}
