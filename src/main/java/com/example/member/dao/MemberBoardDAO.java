package com.example.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberBoardPageDTO;
import com.example.member.dto.MemberBoardSearchDTO;

@Mapper
public interface MemberBoardDAO {

	Integer totalCount();

	List<MemberBoardPageDTO> boardList(MemberBoardPageDTO memberBoardPageDTO);

	List<MemberBoardSearchDTO> boardSearch(MemberBoardSearchDTO memberBoardSearchDTO);

	Integer addBoard(MemberBoardDTO memberBoardDTO);

	Integer updateBoard(MemberBoardDTO memberBoardDTO);

	Integer deleteBoard(MemberBoardDTO memberBoardDTO);

}
