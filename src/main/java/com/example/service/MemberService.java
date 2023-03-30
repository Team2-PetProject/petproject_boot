package com.example.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		String password = dto.getMember_passwd();
		MessageDigest messageDigest = MessageDigest.getInstance("sha-512");
		messageDigest.reset();
		messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
		password = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
		dto.setMember_passwd(password);
		
		int n = dao.memberAdd(session,dto);
		return n;
	}
	
}//end class