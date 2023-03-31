package com.example.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberDTO;

@Repository
public class MemberDAO {

	public int memberAdd(SqlSessionTemplate session,MemberDTO dto) {
		int n = session.insert("memberAdd",dto);
		return n;
	}

	public MemberDTO mypage(SqlSessionTemplate session, String member_code) {
		
		return session.selectOne("mypage",member_code);
	}

	public MemberDTO login(SqlSessionTemplate session, Map<String, String> map) {
		
		return session.selectOne("login",map);
	}

	
}
