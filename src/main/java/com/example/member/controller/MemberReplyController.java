package com.example.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.service.MemberBoardService;
import com.example.member.service.MemberReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class MemberReplyController {

	@Autowired
	MemberReplyService memberReplyService;

	// 게시판에 달린 댓글 리스트 조회 //페이징처리
	@ApiOperation(value = "boardReplyList")
	@GetMapping("check/board/{boardCd}/{curPage}")
	public ComResponseEntity<List<MemberBoardListDTO>> boardReplyList(@PathVariable(name = "boardCd") Integer boardCd,
			@PathVariable(name = "curPage", required = false) Integer curPage) {
		if (curPage == 0) {
			curPage = 1;
		}
		List<MemberBoardListDTO> boardReplyList = memberReplyService.boardReplyList(curPage);
		return new ComResponseEntity<>(new ComResponseDTO<>("댓글목록", boardReplyList));
	}

	// 댓글 만들기
	@ApiOperation(value = "createReply")
	@PostMapping("check/board/createReply/{boardCd}")
	public ComResponseEntity<MemberBoardDTO> createReply(@PathVariable(name = "boardCd")Integer boardCd) {
		MemberBoardDTO createReply = memberReplyService.createReply(boardCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("후기게시판", createReply));
	}

	// 대댓글 만들기
	@ApiOperation(value = "createSubReply")
	@PostMapping("check/board/createReply/{boardCd}/{rplCd}")
	public ComResponseEntity<MemberBoardDTO> createSubReply(@PathVariable(name = "boardCd")Integer boardCd,
			@PathVariable(name = "rplCd") Integer rplCd) {
		MemberBoardDTO createSubReply = memberReplyService.createSubReply(boardCd, rplCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("후기게시판", createSubReply));
	}

	// 댓글 수정
	@ApiOperation(value = "updateReply")
	@PutMapping("check/board/updateReply/{boardCd}/{rplCd}")
	public ComResponseEntity<MemberBoardDTO> updateReply(@PathVariable(name = "boardCd") Integer boardCd,
			@PathVariable(name = "rplCd")Integer rplCd) {
		MemberBoardDTO updateReply = memberReplyService.updateReply(boardCd, rplCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시글수정", updateReply));
	}

	// 게시판삭제
	@ApiOperation(value = "deleteReply")
	@DeleteMapping("check/board/deleteReply/{boardCd}/{rplCd}")
	public ComResponseEntity<MemberBoardDTO> deleteReply(@PathVariable(name = "boardCd") Integer boardCd,
			@PathVariable(name = "rplCd")Integer rplCd) {
		MemberBoardDTO deleteReply = memberReplyService.deleteReply(boardCd, rplCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시글삭제", deleteReply));
	}

}
