package com.example.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.common.constant.ComConstant;
import com.example.member.dto.MemberDTO;

public class SessionAttributeManager {

	public static MemberDTO getMemberInfo() {
		HttpSession session = getSession();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute(ComConstant.MEMBER_ID);
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setMbId("1");
//		memberDTO.setPw("4dff4ea340f0a823f15d3f4f01ab62eae0e5da579ccb851f8db9dfe84c58b2b37b89903a740e1ee172da793a6e79d560e5f7f9bd058a12a280433ed6fa46510a");
//		memberDTO.setNm("루시");
//		memberDTO.setPost(12345);
//		memberDTO.setAddr1("서울시 강남구 강남대로135길 123");
//		memberDTO.setAddr2("둘리빌딩 5F PM실");
//		memberDTO.setTel1("010");
//		memberDTO.setTel2("123");
//		memberDTO.setTel3("4567");
//		memberDTO.setEmail1("pet");
//		memberDTO.setEmail2("@gmail.com");
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
