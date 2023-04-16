package com.example.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("JoinItemDTO")
public class JoinItemDTO {

	private List<ItemDTO> list;
	private Integer totalPage;
	private Integer curPage;
	public List<ItemDTO> getList() {
		return list;
	}
	public void setList(List<ItemDTO> list) {
		this.list = list;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JoinItemDTO [list=");
		builder.append(list);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append("]");
		return builder.toString();
	}


}