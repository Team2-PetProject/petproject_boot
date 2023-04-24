package com.example.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.SessionAttributeManager;
import com.example.member.dao.MemberBoardDAO;
import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberBoardPageDTO;
import com.example.member.dto.MemberBoardSearchDTO;

@Service
public class MemberBoardService {
	@Autowired
	MemberBoardDAO memberBoardDAO;

	public List<MemberBoardPageDTO> boardList(Integer curPage) {
		MemberBoardPageDTO memberBoardPageDTO = paging(curPage);
		List<MemberBoardPageDTO> boardList = memberBoardDAO.boardList(memberBoardPageDTO);
		return boardList;
	}

	public List<MemberBoardSearchDTO> boardSearch(Integer curPage, String title) {
		MemberBoardPageDTO memberBoardPageDTO = paging(curPage);
		MemberBoardSearchDTO memberBoardSearchDTO = new MemberBoardSearchDTO();
		memberBoardSearchDTO.setTitle(title);
		memberBoardSearchDTO.setCurPage(memberBoardPageDTO.getPerPage());
		memberBoardSearchDTO.setStartIdx(memberBoardPageDTO.getStartIdx());
		memberBoardSearchDTO.setEndIdx(memberBoardPageDTO.getEndIdx());
		memberBoardSearchDTO.setPerPage(memberBoardPageDTO.getPerPage());
		memberBoardSearchDTO.setTotalPage(memberBoardPageDTO.getTotalPage());
		List<MemberBoardSearchDTO>boardList = memberBoardDAO.boardSearch(memberBoardSearchDTO);
		return boardList;
	}

	public Integer addBoard(MemberBoardDTO memberBoardDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberBoardDTO.setMbId(mbId);
		Integer addBoard = memberBoardDAO.addBoard(memberBoardDTO);
		return addBoard;
	}

	public Integer updateBoard(Integer boardCd, MemberBoardDTO memberBoardDTO) {
		String mbId = SessionAttributeManager.getMemberId();
		memberBoardDTO.setBoardCd(boardCd);
		memberBoardDTO.setMbId(mbId);
		Integer updateBoard = memberBoardDAO.updateBoard(memberBoardDTO);
		return updateBoard;
	}

	public Integer deleteBoard(Integer boardCd) {
		String mbId = SessionAttributeManager.getMemberId();
		MemberBoardDTO memberBoardDTO = new MemberBoardDTO();
		memberBoardDTO.setMbId(mbId);
		Integer deleteBoard = memberBoardDAO.deleteBoard(memberBoardDTO);
		return deleteBoard;
	}

	private MemberBoardPageDTO paging(Integer curPage) {
		MemberBoardPageDTO memberBoardPageDTO = new MemberBoardPageDTO();
		String mbId = SessionAttributeManager.getMemberId();
		Integer totalCount = memberBoardDAO.totalCount();
		Integer perPage = memberBoardPageDTO.getPerPage();
		Integer totalPage = (int) Math.ceil((int) totalCount / (double) perPage);
		Integer startIdx = ((curPage - 1) * perPage) + 1;
		Integer endIdx = curPage * perPage;
		memberBoardPageDTO.setPerPage(perPage);
		memberBoardPageDTO.setStartIdx(startIdx);
		memberBoardPageDTO.setEndIdx(startIdx);
		memberBoardPageDTO.setEndIdx(endIdx);
		memberBoardPageDTO.setTotalPage(totalPage);

		return memberBoardPageDTO;
	}
}
