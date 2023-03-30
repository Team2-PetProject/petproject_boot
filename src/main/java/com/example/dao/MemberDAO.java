package com.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberDTO;

@Repository
public class MemberDAO {

	public int memberAdd(SqlSessionTemplate session,MemberDTO dto) {
		int n = session.insert("memberAdd",dto);
		return n;
	}

	
}
