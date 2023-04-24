package com.example.member.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("MemberBoardDTO")
public class MemberReplyDTO {

	private Double rplCd;
	private String mbId;
	private Double boardCd;
	private String rplCn;
	private Double parentRpl;
	private Date crtTm;
	private Date upTm;
	private Double depth;

	public Double getRplCd() {
		return rplCd;
	}

	public void setRplCd(Double rplCd) {
		this.rplCd = rplCd;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public Double getBoardCd() {
		return boardCd;
	}

	public void setBoardCd(Double boardCd) {
		this.boardCd = boardCd;
	}

	public String getRplCn() {
		return rplCn;
	}

	public void setRplCn(String rplCn) {
		this.rplCn = rplCn;
	}

	public Double getParentRpl() {
		return parentRpl;
	}

	public void setParentRpl(Double parentRpl) {
		this.parentRpl = parentRpl;
	}

	public Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}

	public Date getUpTm() {
		return upTm;
	}

	public void setUpTm(Date upTm) {
		this.upTm = upTm;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBoardDTO [rplCd=");
		builder.append(rplCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", boardCd=");
		builder.append(boardCd);
		builder.append(", rplCn=");
		builder.append(rplCn);
		builder.append(", parentRpl=");
		builder.append(parentRpl);
		builder.append(", crtTm=");
		builder.append(crtTm);
		builder.append(", upTm=");
		builder.append(upTm);
		builder.append(", depth=");
		builder.append(depth);
		builder.append("]");
		return builder.toString();
	}

}
