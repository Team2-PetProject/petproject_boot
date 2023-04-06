package com.example.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("ItemListDTO")
//public class ItemListPageDTO {
public class ItemListDTO {
	private List<ItemDTO> list;
	private int curPage; //보여질 페이지번호
	private int perPage = 8; //한 페이지에 보여질 상품 갯수
	private int totalCount; //전체 레코드 갯수
	
	public ItemListDTO() {
	//public ItemListPageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
		builder.append("ItemListDTO [list=");
		builder.append(list);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append("]");
		return builder.toString();
	}
	
}
