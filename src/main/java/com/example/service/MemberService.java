package com.example.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.dto.LoginDTO;
import com.example.dto.MemberDTO;


@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	public int memberAdd(MemberDTO memberDTO) throws NoSuchAlgorithmException {
		String password = memberDTO.getPw();
		MessageDigest messageDigest = MessageDigest.getInstance("sha-512");
		messageDigest.reset();
		messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
		password = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
		memberDTO.setPw(password);
		
		int n = dao.memberAdd(memberDTO);
		return n;
	}
	
	public MemberDTO mypage(String mbId) {
		MemberDTO memberDTO = dao.mypage(mbId);
		return memberDTO;
	}
	
	public MemberDTO login(LoginDTO loginDTO) {
		System.out.println("비밀번호 "+ loginDTO.getPw());
		String pw = loginDTO.getPw();
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("sha-512");
			messageDigest.reset();
			messageDigest.update(pw.getBytes(StandardCharsets.UTF_8));
			pw = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
			loginDTO.setPw(pw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MemberDTO memberDTO = dao.login( loginDTO);
		return memberDTO;
	}
	
}//end class