package com.example.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SessionAttributeManager;
import com.example.member.dao.MemberReplyDAO;
import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberReplyDTO;

@Service
public class MemberReplyService {
	@Autowired
	MemberReplyDAO memberReplyDAO;

	public List<MemberBoardListDTO> boardReplyList(Integer boardCd, Integer curPage) {
		BoardReplyLPageDTO boardReplyListDTO = new BoardReplyLPageDTO();
		boardReplyListDTO = paging(curPage, boardCd);
		List<MemberBoardListDTO> boardReplyList = memberReplyDAO.boardReplyList(boardReplyListDTO);
		return null;
	}

	public Integer addReply(MemberReplyDTO memberReplyDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberReplyDTO.setMbId(mbId);
		Integer addReply = memberReplyDAO.addReply(memberReplyDTO);
		return addReply;
	}

	public MemberBoardDTO createSubReply(Integer boardCd, Integer rplCd) {
		return null;
	}

	public MemberBoardDTO updateReply(Integer boardCd, Integer rplCd) {
		return null;
	}

	public MemberBoardDTO deleteReply(Integer boardCd, Integer rplCd) {
		return null;
	}

	private BoardReplyLPageDTO paging(Integer curPage, Integer boardCd) {
		BoardReplyLPageDTO boardReplyListDTO = new BoardReplyLPageDTO();
		Integer totalCount = memberReplyDAO.totalCount(boardCd);
		Integer perPage = boardReplyListDTO.getPerPage();
		Integer totalPage = (int) Math.ceil((int) totalCount / (double) perPage);
		Integer startIdx = ((curPage - 1) * perPage) + 1;
		Integer endIdx = curPage * perPage;
		boardReplyListDTO.setPerPage(perPage);
		boardReplyListDTO.setStartIdx(startIdx);
		boardReplyListDTO.setEndIdx(startIdx);
		boardReplyListDTO.setEndIdx(endIdx);
		boardReplyListDTO.setTotalPage(totalPage);

		return boardReplyListDTO;
	}

}
