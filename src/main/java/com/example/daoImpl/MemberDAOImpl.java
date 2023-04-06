//package com.example.daoImpl;
//
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class MemberDAOImpl {
//	public int memberAdd(SqlSessionTemplate session,MemberDTO dto) {
//		int n = session.insert("memberAdd",dto);
//		return n;
//	}
//
//	public MemberDTO mypage(SqlSessionTemplate session, String member_code) {
//		
//		return session.selectOne("mypage",member_code);
//	}
//
//	public MemberDTO login(SqlSessionTemplate session, Map<String, String> map) {
//		
//		return session.selectOne("login",map);
//	}
//
//	
//}
