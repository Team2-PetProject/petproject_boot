package com.example.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.member.dto.BoardReplyLPageDTO;
import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberReplyDTO;
import com.example.member.service.MemberReplyService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MemberReplyController {

	@Autowired
	MemberReplyService memberReplyService;

	// 게시판에 달린 댓글 리스트 조회 //페이징처리
	@ApiOperation(value = "boardReplyList")
	@GetMapping("check/board/{boardCd}/{curPage}")
	public ComResponseEntity<BoardReplyLPageDTO> boardReplyList(@PathVariable(name = "boardCd") Integer boardCd,
			@PathVariable(name = "curPage", required = false) Integer curPage) {
		if (curPage == 0) {
			curPage = 1;
		}
		BoardReplyLPageDTO boardReplyList = memberReplyService.boardReplyList(boardCd, curPage);
		return new ComResponseEntity<>(new ComResponseDTO<>("댓글목록", boardReplyList));
	}

	// 댓글 만들기
	@ApiOperation(value = "addReply")
	@PostMapping("check/board/addReply/{boardCd}")
	public ComResponseEntity<Integer> addReply(@PathVariable(name = "boardCd")Integer boardCd,
			@RequestBody MemberReplyDTO memberReplyDTO) {
		memberReplyDTO.setBoardCd(boardCd);
		Integer addReply = memberReplyService.addReply(memberReplyDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("후기게시판"));
	}

	// 대댓글 만들기
	@ApiOperation(value = "addSubReply")
	@PostMapping("check/board/addReply/{boardCd}/{rplCd}")
	public ComResponseEntity<MemberReplyDTO> createSubReply(@PathVariable(name = "boardCd")Integer boardCd,
			@PathVariable(name = "rplCd") Integer rplCd, @RequestBody MemberReplyDTO memberReplyDTO) {

		memberReplyDTO = memberReplyService.addSubReply(boardCd, rplCd,memberReplyDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("후기게시판", memberReplyDTO));
	}

	// 댓글 수정
	@ApiOperation(value = "updateReply")
	@PutMapping("check/board/updateReply/{boardCd}/{rplCd}")
	public ComResponseEntity<MemberReplyDTO> updateReply(@PathVariable(name = "boardCd") Integer boardCd,
			@PathVariable(name = "rplCd")Integer rplCd) {
		MemberReplyDTO updateReply = memberReplyService.updateReply(boardCd, rplCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시글수정", updateReply));
	}

	// 게시판삭제
	@ApiOperation(value = "deleteReply")
	@DeleteMapping("check/board/deleteReply/{boardCd}/{rplCd}")
	public ComResponseEntity<MemberReplyDTO> deleteReply(@PathVariable(name = "boardCd") Integer boardCd,
			@PathVariable(name = "rplCd")Integer rplCd) {
		MemberReplyDTO deleteReply = memberReplyService.deleteReply(boardCd, rplCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시글삭제", deleteReply));
	}

}
