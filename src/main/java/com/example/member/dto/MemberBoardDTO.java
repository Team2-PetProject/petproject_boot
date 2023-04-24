package com.example.member.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("MemberBoardDTO")
public class MemberBoardDTO {

	private Integer boardCd; //게시판번호
	private String mbId; //작성자
	private String title; //제목
	private String cn; //내용
	private Integer rplCnt; //댓글 갯수
	private Date crtTm; //업로드시간
	private Date upTm; //수정 시간
	public Integer getBoardCd() {
		return boardCd;
	}
	public String getMbId() {
		return mbId;
	}
	public String getTitle() {
		return title;
	}
	public String getCn() {
		return cn;
	}
	public Integer getRplCnt() {
		return rplCnt;
	}
	public Date getCrtTm() {
		return crtTm;
	}
	public Date getUpTm() {
		return upTm;
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
	public void setCn(String cn) {
		this.cn = cn;
	}
	public void setRplCnt(Integer rplCnt) {
		this.rplCnt = rplCnt;
	}
	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}
	public void setUpTm(Date upTm) {
		this.upTm = upTm;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBoardDTO [boardCd=");
		builder.append(boardCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", cn=");
		builder.append(cn);
		builder.append(", rplCnt=");
		builder.append(rplCnt);
		builder.append(", crtTm=");
		builder.append(crtTm);
		builder.append(", upTm=");
		builder.append(upTm);
		builder.append("]");
		return builder.toString();
	}

	
	

}
