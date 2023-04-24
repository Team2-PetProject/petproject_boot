package com.example.member.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("MemberReplyDTO")
public class MemberReplyDTO {

	private Integer rplCd;
	private String mbId;
	private Integer boardCd;
	private String rplCn;
	private Integer parentRpl;
	private Date crtTm;
	private Date upTm;
	private Integer depth;

	public Integer getRplCd() {
		return rplCd;
	}
	public String getMbId() {
		return mbId;
	}
	public Integer getBoardCd() {
		return boardCd;
	}
	public String getRplCn() {
		return rplCn;
	}
	public Integer getParentRpl() {
		return parentRpl;
	}
	public Date getCrtTm() {
		return crtTm;
	}
	public Date getUpTm() {
		return upTm;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setRplCd(Integer rplCd) {
		this.rplCd = rplCd;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public void setBoardCd(Integer boardCd) {
		this.boardCd = boardCd;
	}
	public void setRplCn(String rplCn) {
		this.rplCn = rplCn;
	}
	public void setParentRpl(Integer parentRpl) {
		this.parentRpl = parentRpl;
	}
	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}
	public void setUpTm(Date upTm) {
		this.upTm = upTm;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberReplyDTO [rplCd=");
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
