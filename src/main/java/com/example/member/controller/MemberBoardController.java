package com.example.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.member.dto.MemberBoardDTO;
import com.example.member.dto.MemberBoardListDTO;
import com.example.member.dto.MemberBoardPageDTO;
import com.example.member.dto.MemberBoardSearchDTO;
import com.example.member.service.MemberBoardService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MemberBoardController {

	@Autowired
	MemberBoardService memberBoardService;

	// 게시판 리스트
	@ApiOperation(value = "boardList")
	@GetMapping("check/board/{curPage}")
	public ComResponseEntity<List<MemberBoardPageDTO>> boardList(
			@PathVariable(name = "curPage", required = false) Integer curPage) {
		if (curPage == 0) {
			curPage = 1;
		}
		List<MemberBoardPageDTO> boardList = memberBoardService.boardList(curPage);
		return new ComResponseEntity<>(new ComResponseDTO<>("후기게시판", boardList));
	}

	// 게시판 상세 조회
	@ApiOperation(value = "boardSearch")
	@GetMapping("check/board/{curPage}/title/{title}")
	public ComResponseEntity<List<MemberBoardSearchDTO>> boardSearch(
			@PathVariable(name = "curPage", required = false) Integer curPage,
			@PathVariable(name = "title") String title) {
		if (curPage == 0) {
			curPage = 1;
		}
		List<MemberBoardSearchDTO> boardList = memberBoardService.boardSearch(curPage, title);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시판상세조회", boardList));
	}

	// 게시글 만들기
	@ApiOperation(value = "addBoard")
	@PostMapping("check/board/addBoard")
	public ComResponseEntity<Integer> addBoard(@RequestBody MemberBoardDTO memberBoardDTO) {
		memberBoardService.addBoard(memberBoardDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("후기게시판"));
	}

	// 게시판수정
	@ApiOperation(value = "updateBoard")
	@PutMapping("check/board/update/{boardCd}")
	public ComResponseEntity<Integer> updateBoard(@PathVariable(name = "boardCd") Integer boardCd,
			@RequestBody MemberBoardDTO memberBoardDTO) {
		memberBoardService.updateBoard(boardCd,memberBoardDTO);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시글수정"));
	}

	// 게시판삭제
	@ApiOperation(value = "deleteBoard")
	@DeleteMapping("check/board/del/{boardCd}")
	public ComResponseEntity<Integer> deleteBoard(@PathVariable(name = "boardCd") Integer boardCd) {
		memberBoardService.deleteBoard(boardCd);
		return new ComResponseEntity<>(new ComResponseDTO<>("게시글삭제"));
	}

}
