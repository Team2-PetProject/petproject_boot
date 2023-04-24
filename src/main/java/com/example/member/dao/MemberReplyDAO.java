package com.example.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberReplyDTO;

@Mapper
public interface MemberReplyDAO {

	Integer totalCountReply(Integer boardCd);

	BoardReplyLPageDTO boardReplyList(BoardReplyLPageDTO boardReplyListDTO);

	Integer addReply(MemberReplyDTO memberReplyDTO);


}
