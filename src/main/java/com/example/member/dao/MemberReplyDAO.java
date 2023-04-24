package com.example.member.dao;

import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberReplyDTO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberReplyDAO {

	Integer totalCountReply(Integer boardCd);

	List<MemberReplyDTO> boardReplyList(BoardReplyLPageDTO boardReplyListDTO);

	Integer addReply(MemberReplyDTO memberReplyDTO);

	Integer addSubReply(MemberReplyDTO memberReplyDTO);

	Integer depthMaxValue(MemberReplyDTO memberReplyDTO);

	Integer updateReply(MemberReplyDTO memberReplyDTO);

	Integer deleteReply(MemberReplyDTO memberReplyDTO);


}
