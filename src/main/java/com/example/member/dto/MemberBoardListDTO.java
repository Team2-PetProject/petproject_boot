package com.example.member.dto;

import org.apache.ibatis.type.Alias;

@Alias("MemberBoardListDTO")
public class MemberBoardListDTO {

	private Double boardCd; //게시판번호
	private String mbId; //작성자
	private String title; //제목
	private Double rplCnt; //댓글 갯수

	public Double getBoardCd() {
		return boardCd;
	}

	public void setBoardCd(Double boardCd) {
		this.boardCd = boardCd;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRplCnt() {
		return rplCnt;
	}

	public void setRplCnt(Double rplCnt) {
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
