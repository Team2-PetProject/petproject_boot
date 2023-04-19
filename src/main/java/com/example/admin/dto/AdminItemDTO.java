package com.example.admin.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("AdminItemDTO")
public class AdminItemDTO {
	private List<ItemCdNmDTO> list;
	private Integer totalPage;
	private Integer curPage;
	public List<ItemCdNmDTO> getList() {
		return list;
	}
	public void setList(List<ItemCdNmDTO> list) {
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
		builder.append("AdminItemDTO [list=");
		builder.append(list);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append("]");
		return builder.toString();
	}
	
}	
