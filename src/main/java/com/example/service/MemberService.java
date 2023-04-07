package com.example.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SessionAttributeManager;
import com.example.dao.MemberDAO;
import com.example.dto.LoginDTO;
import com.example.dto.MemberDTO;


@Service
public class MemberService {
	@Autowired
	MemberDAO memberDao;
	
	public int memberAdd(MemberDTO memberDTO) {
		String password = memberDTO.getPw();
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("sha-512");
			messageDigest.reset();
			messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
			password = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
			memberDTO.setPw(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n = memberDao.memberAdd(memberDTO);
		return n;
	}
	
	public MemberDTO mypage(String mbId) {
		MemberDTO memberDTO = memberDao.mypage(mbId);
		return memberDTO;
	}
	
	public MemberDTO login(LoginDTO loginDTO) {
//		System.out.println("비밀번호 "+ loginDTO.getPw());
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
		
		MemberDTO memberDTO = memberDao.login(loginDTO);
		return memberDTO;
	}

	public Integer memberUpdate(MemberDTO memberDTO) {
		String prePw =  SessionAttributeManager.getMemberInfo().getPw();
		String newPw = memberDTO.getPw();
		if(newPw != prePw) {
			MessageDigest messageDigest;
			try {
				messageDigest = MessageDigest.getInstance("sha-512");
				messageDigest.reset();
				messageDigest.update(newPw.getBytes(StandardCharsets.UTF_8));
				newPw = String.format("%0128x", new BigInteger(1,messageDigest.digest()));
				memberDTO.setPw(newPw);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer n = memberDao.memberUpdate(memberDTO);
		return n;
	}
	
}//end class