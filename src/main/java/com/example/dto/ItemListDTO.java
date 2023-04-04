package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemListDTO")
public class ItemListDTO {
	private int itemCd;
	private int itemListCd;
	private int curPage; //페이지 번호
	private int perPage = 4; //페이지에 보여질 목록 수
	public ItemListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemListDTO(int itemCd, int itemListCd, int curPage, int perPage) {
		super();
		this.itemCd = itemCd;
		this.itemListCd = itemListCd;
		this.curPage = curPage;
		this.perPage = perPage;
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
	public int getItem_Code() {
		return itemCd;
	}
	public void setItem_Code(int item_Code) {
		itemCd = item_Code;
	}
	public int getItem_List_Code() {
		return itemListCd;
	}
	public void setItem_List_Code(int item_List_Code) {
		itemListCd = item_List_Code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemListDTO [itemCd=");
		builder.append(itemCd);
		builder.append(", itemListCd=");
		builder.append(itemListCd);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append("]");
		return builder.toString();
	}
	
	
}
