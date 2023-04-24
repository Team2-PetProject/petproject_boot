package com.example.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberReplyDTO;

@Mapper
public interface MemberReplyDAO {

	Integer totalCount(Integer boardCd);

	List<MemberBoardListDTO> boardReplyList(BoardReplyLPageDTO boardReplyListDTO);

	Integer addReply(MemberReplyDTO memberReplyDTO);

}
