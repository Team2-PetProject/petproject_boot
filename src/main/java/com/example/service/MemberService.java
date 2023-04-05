package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daoImpl.MemberDAOImpl;
import com.example.dto.CartDTO;

@Service("memberService")
public class MemberService {
	@Autowired
	MemberDAOImpl dao;
	@Autowired
	SqlSessionTemplate session;
	
	
}//end class