package com.example.CartOrder.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("OrderSearchPagingDTO")
public class OrderSearchPagingDTO {

	private List<OrderSearchDTO> list; // 현재페이지에 들어갈 레코드를 perPage만큼만 저장할 것입니다.
	private Integer curPage; // 현재 볼 페이지 번호
	private Integer perPage = 10; // 한 페이지에 보여질 목록 수
	private Integer totalPage;

	public List<OrderSearchDTO> getList() {
		return list;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setList(List<OrderSearchDTO> list) {
		this.list = list;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderSearchPagingDTO [list=");
		builder.append(list);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append("]");
		return builder.toString();
	}

}