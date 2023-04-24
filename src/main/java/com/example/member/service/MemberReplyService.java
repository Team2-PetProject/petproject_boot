package com.example.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SessionAttributeManager;
import com.example.member.dao.MemberReplyDAO;
import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberReplyDTO;

@Service
public class MemberReplyService {
	@Autowired
	MemberReplyDAO memberReplyDAO;

	public BoardReplyLPageDTO boardReplyList(Integer boardCd, Integer curPage) {
		BoardReplyLPageDTO boardReplyListDTO = new BoardReplyLPageDTO();
		boardReplyListDTO = paging(curPage, boardCd);
		BoardReplyLPageDTO boardReplyList = memberReplyDAO.boardReplyList(boardReplyListDTO);
		return boardReplyList;
	}

	public Integer addReply(MemberReplyDTO memberReplyDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberReplyDTO.setMbId(mbId);
		Integer addReply = memberReplyDAO.addReply(memberReplyDTO);
		return addReply;
	}

	public MemberReplyDTO addSubReply(Integer boardCd, Integer rplCd, MemberReplyDTO memberReplyDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberReplyDTO.setMbId(mbId);
		memberReplyDTO.setBoardCd(boardCd);
		memberReplyDTO.setRplCd(rplCd);

		Integer depth = memberReplyDTO.getDepth();
		if (depth == 0) {
			depth = 1;
		} else if (depth>1) {
			Integer depthMaxValue = memberReplyDAO.depthMaxValue(rplCd);
		}
		return null;
	}

	public MemberReplyDTO updateReply(Integer boardCd, Integer rplCd) {
		return null;
	}

	public MemberReplyDTO deleteReply(Integer boardCd, Integer rplCd) {
		return null;
	}

	private BoardReplyLPageDTO paging(Integer curPage, Integer boardCd) {
		BoardReplyLPageDTO boardReplyListDTO = new BoardReplyLPageDTO();
		Integer totalCount = memberReplyDAO.totalCountReply(boardCd);
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
