package com.example.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("ItemListDTO")
public class ItemListDTO {
	private List<ItemDTO> list;
	private int curPage;
	private int perPage = 4;
	
	public ItemListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ItemDTO> getList() {
		return list;
	}

	public void setList(List<ItemDTO> list) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTO [list=");
		builder.append(list);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append("]");
		return builder.toString();
	}
	
	
}
