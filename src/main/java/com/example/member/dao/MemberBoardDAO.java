package com.example.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberBoardPageDTO;

@Mapper
public interface MemberBoardDAO {

	Integer totalCountBoard();

	Integer totalSearchCount(String title);

	List<MemberBoardListDTO> boardList(MemberBoardPageDTO memberBoardPageDTO);

	List<MemberBoardListDTO> boardSearch(MemberBoardPageDTO memberBoardPageDTO);

	Integer addBoard(MemberBoardDTO memberBoardDTO);

	Integer updateBoard(MemberBoardDTO memberBoardDTO);

	Integer deleteBoard(MemberBoardDTO memberBoardDTO);

	Integer countrplCnt(Integer boardCd);

	MemberBoardDTO boardSelectOne(Integer boardCd);

}
