package com.example.member.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("MemberBoardPageDTO")
public class MemberBoardPageDTO {

		private List<MemberBoardListDTO> list;
		private Integer curPage; //현재 볼 페이지 번호
		private Integer perPage = 10; //한 페이지에 보여질 목록 수
		private Integer startIdx;
		private Integer endIdx;
		private Integer totalPage;
		private String title;

		public List<MemberBoardListDTO> getList() {
			return list;
		}
		public Integer getCurPage() {
			return curPage;
		}
		public Integer getPerPage() {
			return perPage;
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
		public String getTitle() {
			return title;
		}
		public void setList(List<MemberBoardListDTO> list) {
			this.list = list;
		}
		public void setCurPage(Integer curPage) {
			this.curPage = curPage;
		}
		public void setPerPage(Integer perPage) {
			this.perPage = perPage;
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
		public void setTitle(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MemberBoardPageDTO [list=");
			builder.append(list);
			builder.append(", curPage=");
			builder.append(curPage);
			builder.append(", perPage=");
			builder.append(perPage);
			builder.append(", startIdx=");
			builder.append(startIdx);
			builder.append(", endIdx=");
			builder.append(endIdx);
			builder.append(", totalPage=");
			builder.append(totalPage);
			builder.append(", title=");
			builder.append(title);
			builder.append("]");
			return builder.toString();
		}



}