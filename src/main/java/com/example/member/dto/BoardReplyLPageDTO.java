package com.example.member.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("BoardReplyListDTO")
public class BoardReplyLPageDTO {

	private List<MemberReplyDTO> list;
	private Integer curPage; //현재 볼 페이지 번호
	private Integer perPage = 30; //한 페이지에 보여질 목록 수
	private Integer totalCount; //전체 레코드 갯수
	private Integer startIdx;
	private Integer endIdx;
	private Integer totalPage;
	private Integer boardCd;
	private Integer parentRpl;
	public List<MemberReplyDTO> getList() {
		return list;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public Integer getStartIdx() {
		return startIdx;
	}
	public Integer getEndIdx() {
		return endIdx;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getBoardCd() {
		return boardCd;
	}
	public Integer getParentRpl() {
		return parentRpl;
	}
	public void setList(List<MemberReplyDTO> list) {
		this.list = list;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public void setStartIdx(Integer startIdx) {
		this.startIdx = startIdx;
	}
	public void setEndIdx(Integer endIdx) {
		this.endIdx = endIdx;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public void setBoardCd(Integer boardCd) {
		this.boardCd = boardCd;
	}
	public void setParentRpl(Integer parentRpl) {
		this.parentRpl = parentRpl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardReplyLPageDTO [list=");
		builder.append(list);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", startIdx=");
		builder.append(startIdx);
		builder.append(", endIdx=");
		builder.append(endIdx);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append(", boardCd=");
		builder.append(boardCd);
		builder.append(", parentRpl=");
		builder.append(parentRpl);
		builder.append("]");
		return builder.toString();
	}



}
