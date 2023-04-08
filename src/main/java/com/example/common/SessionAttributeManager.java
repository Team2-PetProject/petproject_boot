package com.example.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.common.constant.ComConstant;
import com.example.dto.MemberDTO;

public class SessionAttributeManager {
	 
	public static MemberDTO getMemberInfo() {
		HttpSession session = getSession();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute(ComConstant.MEMBER_ID);
		return memberDTO; 
	}

	public static String getMemberId() {
		MemberDTO memberDTO = getMemberInfo();
		String memberId = memberDTO.getMbId();
		return memberId;
	}
	
	public static HttpSession getSession() {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = req.getSession();
		return session;
	}
	
	
}
