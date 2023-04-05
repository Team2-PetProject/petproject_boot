package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;


@Service("memberService")
public class MemberService {
	@Autowired
	MemberDAO memberDao;
	
}//end class