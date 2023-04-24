package com.example.member.dto;

import org.apache.ibatis.type.Alias;

@Alias("MemberBoardListDTO")
public class MemberBoardListDTO {

	private Integer boardCd; // 게시판번호
	private String mbId; // 작성자
	private String title; // 제목
	private Integer rplCnt; // 댓글 갯수

	public Integer getBoardCd() {
		return boardCd;
	}

	public String getMbId() {
		return mbId;
	}

	public String getTitle() {
		return title;
	}

	public Integer getRplCnt() {
		return rplCnt;
	}

	public void setBoardCd(Integer boardCd) {
		this.boardCd = boardCd;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRplCnt(Integer rplCnt) {
		this.rplCnt = rplCnt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBoardListDTO [boardCd=");
		builder.append(boardCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", rplCnt=");
		builder.append(rplCnt);
		builder.append("]");
		return builder.toString();
	}

}
