package com.example.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.SessionAttributeManager;
import com.example.member.dao.MemberBoardDAO;
import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberBoardPageDTO;

@Service
public class MemberBoardService {
	@Autowired
	MemberBoardDAO memberBoardDAO;

	@Transactional
	public MemberBoardPageDTO boardList(Integer curPage) {
		Integer totalCount = memberBoardDAO.totalCountBoard();
		MemberBoardPageDTO memberBoardPageDTO = paging(curPage,totalCount);
		List<MemberBoardListDTO> boardList = memberBoardDAO.boardList(memberBoardPageDTO);
		memberBoardPageDTO.setList(boardList);
		return memberBoardPageDTO;
	}
	@Transactional
	public MemberBoardPageDTO boardSearch(Integer curPage, String title) {
		Integer totalCount = memberBoardDAO.totalSearchCount(title);
		MemberBoardPageDTO memberBoardPageDTO = paging(curPage,totalCount);
		memberBoardPageDTO.setTitle(title);
		List<MemberBoardListDTO> boardList = memberBoardDAO.boardSearch(memberBoardPageDTO);
		memberBoardPageDTO.setList(boardList);
		return memberBoardPageDTO;
	}
	@Transactional
	public MemberBoardDTO boardSelectOne(Integer boardCd) {
		Integer rplCnt = memberBoardDAO.countrplCnt(boardCd);
		MemberBoardDTO boardSelectOne = new MemberBoardDTO();
		boardSelectOne = memberBoardDAO.boardSelectOne(boardCd);
		boardSelectOne.setRplCnt(rplCnt);
		return boardSelectOne;
	}
	@Transactional
	public Integer addBoard(MemberBoardDTO memberBoardDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberBoardDTO.setMbId(mbId);
		Integer addBoard = memberBoardDAO.addBoard(memberBoardDTO);
		return addBoard;
	}
	@Transactional
	public Integer updateBoard(Integer boardCd, MemberBoardDTO memberBoardDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberBoardDTO.setBoardCd(boardCd);
		memberBoardDTO.setMbId(mbId);
		Integer updateBoard = memberBoardDAO.updateBoard(memberBoardDTO);
		return updateBoard;
	}
	@Transactional
	public Integer deleteBoard(Integer boardCd) {
		String mbId = SessionAttributeManager.getMemberId();
		MemberBoardDTO memberBoardDTO = new MemberBoardDTO();
		memberBoardDTO.setMbId(mbId);
		memberBoardDTO.setBoardCd(boardCd);
		Integer deleteBoard = memberBoardDAO.deleteBoard(memberBoardDTO);
		return deleteBoard;
	}

	private MemberBoardPageDTO paging(Integer curPage, Integer totalCount) {
		MemberBoardPageDTO memberBoardPageDTO = new MemberBoardPageDTO();
		Integer perPage = memberBoardPageDTO.getPerPage();
		Integer totalPage = (int) Math.ceil((int) totalCount / (double) perPage);
		Integer startIdx = ((curPage - 1) * perPage) + 1;
		Integer endIdx = curPage * perPage;
		memberBoardPageDTO.setPerPage(perPage);
		memberBoardPageDTO.setCurPage(curPage);
		memberBoardPageDTO.setStartIdx(startIdx);
		memberBoardPageDTO.setEndIdx(startIdx);
		memberBoardPageDTO.setEndIdx(endIdx);
		memberBoardPageDTO.setTotalPage(totalPage);

		return memberBoardPageDTO;
	}



}
