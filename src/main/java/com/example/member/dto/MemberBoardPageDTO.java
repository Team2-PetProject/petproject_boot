package com.example.member.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("MemberBoardPageDTO")
public class MemberBoardPageDTO {

		private List<MemberBoardListDTO> list;
		private Integer curPage; //현재 볼 페이지 번호
		private Integer perPage = 10; //한 페이지에 보여질 목록 수
		private Integer totalCount; //전체 레코드 갯수
		private Integer startIdx;
		private Integer endIdx;
		private Integer totalPage;
		public List<MemberBoardListDTO> getList() {
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
		public void setList(List<MemberBoardListDTO> list) {
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


}