package com.example.CartOrder.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("OrderHistoryPageDTO")
public class OrderHistoryPageDTO {

	private List<OrderHistoryDTO> list; //현재페이지에 들어갈 레코드를 perPage만큼만 저장할 것입니다.
	private int curPage; //현재 볼 페이지 번호
	private int perPage = 16; //한 페이지에 보여질 목록 수
	private int totalCount; //전체 레코드 갯수

	public OrderHistoryPageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderHistoryPageDTO(List<OrderHistoryDTO> list, int curPage, int perPage, int totalCount) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "OrderHistoryPageDTO [list=" + list + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount="
				+ totalCount + "]";
	}

	public List<OrderHistoryDTO> getList() {
		return list;
	}

	public void setList(List<OrderHistoryDTO> list) {
		this.list = list;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}