package com.example.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.member.dto.LoginDTO;
import com.example.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public Integer memberAdd(MemberDTO memberDTO);
	
	public Integer idCheck(String mbId);

	public MemberDTO mypage(String mbId);

	public MemberDTO login(LoginDTO loginDTO);

	public Integer memberUpdate(MemberDTO memberDTO);
	
	public String idSearch(MemberDTO mDto);

	public Integer pwUpdate(LoginDTO loginDTO);

}