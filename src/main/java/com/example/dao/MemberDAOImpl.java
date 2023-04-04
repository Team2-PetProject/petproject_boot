//package com.example.dao;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.example.dto.LoginDTO;
//import com.example.dto.MemberDTO;
//
//@Repository
//public class MemberDAOImpl implements MemberDAO{
//
//	@Override
//	public int memberAdd(SqlSessionTemplate session, MemberDTO memberDTO) {
//		System.out.println("dao impl" + memberDTO);
//		int n = session.insert("memberAdd",memberDTO);
//		return n;
//	}
//
//	@Override
//	public MemberDTO mypage(SqlSessionTemplate session, String mbId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public MemberDTO login(SqlSessionTemplate session, LoginDTO loginDTO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
