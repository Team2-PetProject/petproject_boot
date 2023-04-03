package com.example.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;

import com.example.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public int memberAdd(SqlSessionTemplate session, MemberDTO dto);

	public MemberDTO mypage(SqlSessionTemplate session, String member_code);

	public MemberDTO login(SqlSessionTemplate session, Map<String, String> map);
	
	

}

