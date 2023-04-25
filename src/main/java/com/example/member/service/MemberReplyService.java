package com.example.member.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.LoggersPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.SessionAttributeManager;
import com.example.member.dao.MemberReplyDAO;
import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberReplyDTO;

@Service
public class MemberReplyService {
	private static final Logger logger = LogManager.getLogger(MemberReplyService.class);

	@Autowired
	MemberReplyDAO memberReplyDAO;
	@Transactional
	public BoardReplyLPageDTO boardReplyList(Integer boardCd, Integer curPage) {
		BoardReplyLPageDTO boardReplyListDTO = new BoardReplyLPageDTO();
		boardReplyListDTO = paging(curPage, boardCd);
		boardReplyListDTO.setParentRpl(boardCd);
		List<MemberReplyDTO> boardReplyList = memberReplyDAO.boardReplyList(boardReplyListDTO);
		boardReplyListDTO.setList(boardReplyList);
		return boardReplyListDTO;
	}
	@Transactional
	public Integer addReply(MemberReplyDTO memberReplyDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberReplyDTO.setMbId(mbId);
		Integer addReply = memberReplyDAO.addReply(memberReplyDTO);
		return addReply;
	}
	@Transactional
	public Integer addSubReply(Integer boardCd, Integer rplCd, MemberReplyDTO memberReplyDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberReplyDTO.setRplCd(rplCd);
		memberReplyDTO.setMbId(mbId);
		memberReplyDTO.setBoardCd(boardCd);
		Integer depth = memberReplyDAO.depthMaxValue(memberReplyDTO);
		depth = depth + 1;
		memberReplyDTO.setDepth(depth);
		memberReplyDTO.setParentRpl(rplCd); // 버튼 누를 때 넘어온 댓글번호를 부모 댓글로 삼는다.
		Integer addReply = memberReplyDAO.addSubReply(memberReplyDTO);

		return addReply;
	}
	@Transactional
	public Integer updateReply(Integer boardCd, Integer rplCd, MemberReplyDTO memberReplyDTO) {
		memberReplyDTO.setBoardCd(boardCd);
		memberReplyDTO.setRplCd(rplCd);
		Integer updateReply = memberReplyDAO.updateReply(memberReplyDTO);
		return updateReply;
	}

	public Integer deleteReply(Integer boardCd, Integer rplCd) {
		MemberReplyDTO memberReplyDTO = new MemberReplyDTO();
		String mbId = SessionAttributeManager.getMemberId();
		memberReplyDTO.setBoardCd(boardCd);
		memberReplyDTO.setRplCd(rplCd);
		memberReplyDTO.setMbId(mbId);
		Integer deleteReply = memberReplyDAO.deleteReply(memberReplyDTO);
		logger.error("deleteReply 메소드 deleteReply Value 값" +  deleteReply);
		return deleteReply;
	}

	private BoardReplyLPageDTO paging(Integer curPage, Integer boardCd) {
		BoardReplyLPageDTO boardReplyListDTO = new BoardReplyLPageDTO();
		Integer totalCount = memberReplyDAO.totalCountReply(boardCd);
		Integer perPage = boardReplyListDTO.getPerPage();
		Integer totalPage = (int) Math.ceil((int) totalCount / (double) perPage);
		Integer startIdx = ((curPage - 1) * perPage) + 1;
		Integer endIdx = curPage * perPage;
		boardReplyListDTO.setBoardCd(boardCd);
		boardReplyListDTO.setPerPage(perPage);
		boardReplyListDTO.setStartIdx(startIdx);
		boardReplyListDTO.setEndIdx(endIdx);
		boardReplyListDTO.setTotalPage(totalPage);

		return boardReplyListDTO;
	}

}
