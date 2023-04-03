package com.example.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.dao.MemberDAO;
import com.example.dto.MemberDTO;



@Service("memberService")
public class MemberService {
	@Autowired
	MemberDAO dao;
	@Autowired
	SqlSessionTemplate session;
	public int memberAdd(MemberDTO dto) throws NoSuchAlgorithmException {
		String password = dto.getPw();
		MessageDigest messageDigest = MessageDigest.getInstance("sha-512");
		messageDigest.reset();
		messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
		password = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
		dto.setPw(password);
		
		int n = dao.memberAdd(session,dto);
		return n;
	}
	public MemberDTO mypage(String member_code) {
		MemberDTO dto = dao.mypage(session,member_code);
		return dto;
	}
	public MemberDTO login(Map<String, String> map) {
		System.out.println("비밀번호 "+ map.get("member_passwd"));
		String member_passwd = map.get("member_passwd");
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("sha-512");
			messageDigest.reset();
			messageDigest.update(member_passwd.getBytes(StandardCharsets.UTF_8));
			member_passwd = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
			map.put("member_passwd", member_passwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MemberDTO dto = dao.login(session, map);
		return dto;
	}
	
	
}//end class