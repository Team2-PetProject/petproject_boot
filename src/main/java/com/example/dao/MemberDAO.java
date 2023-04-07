package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.LoginDTO;
import com.example.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public Integer memberAdd(MemberDTO memberDTO);
	
	public Integer idCheck(String mbId);

	public MemberDTO mypage(String mbId);

	public MemberDTO login(LoginDTO loginDTO);

	public Integer memberUpdate(MemberDTO memberDTO);

	
}
