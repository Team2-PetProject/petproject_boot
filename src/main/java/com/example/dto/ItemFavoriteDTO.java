package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemFavoriteDTO")
public class ItemFavoriteDTO {
	private String Member_Code;
	private int Item_Code;
	public ItemFavoriteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemFavoriteDTO(String member_Code, int item_Code) {
		super();
		Member_Code = member_Code;
		Item_Code = item_Code;
	}
	public String getMember_Code() {
		return Member_Code;
	}
	public void setMember_Code(String member_Code) {
		Member_Code = member_Code;
	}
	public int getItem_Code() {
		return Item_Code;
	}
	public void setItem_Code(int item_Code) {
		Item_Code = item_Code;
	}
	@Override
	public String toString() {
		return "ItemFavoriteDTO [Member_Code=" + Member_Code + ", Item_Code=" + Item_Code + "]";
	}
	
}
