package com.example.member.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SessionAttributeManager;
import com.example.member.dao.MemberDAO;
import com.example.member.dto.LoginDTO;
import com.example.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDao;

	public static String encryptSHA512(String password) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("sha-512");
			messageDigest.reset();
			messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
			password = String.format("%0128x", new BigInteger(1, messageDigest.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}

	public Integer memberAdd(MemberDTO memberDTO) {
		String password = memberDTO.getPw();
		password = encryptSHA512(password);
		memberDTO.setPw(password);

		Integer n = memberDao.memberAdd(memberDTO);
		return n;
	}

	public Integer idCheck(String mbId) {
		Integer count = memberDao.idCheck(mbId);
		return count;
	}

	public MemberDTO mypage(String mbId) {
		MemberDTO memberDTO = memberDao.mypage(mbId);
		return memberDTO;
	}

	public MemberDTO login(LoginDTO loginDTO) {
		String pw = loginDTO.getPw();
		pw = encryptSHA512(pw);
		loginDTO.setPw(pw);
		
		MemberDTO memberDTO = memberDao.login(loginDTO);
		return memberDTO;
	}

	public Integer memberUpdate(MemberDTO memberDTO) {
		String prePw = SessionAttributeManager.getMemberInfo().getPw();
		String newPw = memberDTO.getPw();
		if (newPw != prePw) {
			newPw = encryptSHA512(newPw);
			memberDTO.setPw(newPw);
		}
		Integer n = memberDao.memberUpdate(memberDTO);
		return n;
	}

}// end class