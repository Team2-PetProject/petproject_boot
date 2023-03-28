package com.example.dto;

public class ItemListDTO {
	private int Item_Code;
	private int Item_List_Code;
	public ItemListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemListDTO(int item_Code, int item_List_Code) {
		super();
		Item_Code = item_Code;
		Item_List_Code = item_List_Code;
	}
	public int getItem_Code() {
		return Item_Code;
	}
	public void setItem_Code(int item_Code) {
		Item_Code = item_Code;
	}
	public int getItem_List_Code() {
		return Item_List_Code;
	}
	public void setItem_List_Code(int item_List_Code) {
		Item_List_Code = item_List_Code;
	}
	@Override
	public String toString() {
		return "ItemListDTO [Item_Code=" + Item_Code + ", Item_List_Code=" + Item_List_Code + "]";
	}
	
}
