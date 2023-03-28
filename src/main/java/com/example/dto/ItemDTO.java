package com.example.dto;

public class ItemDTO {
	private int Item_Code;
	private int Item_List_Code;
	private String Item_Name;
	private int Item_Price;
	private int Item_Image;
	private String Item_Category;
	private String Item_Spec;
	private String Item_Add;
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDTO(int item_Code, int item_List_Code, String item_Name, int item_Price, int item_Image,
			String item_Category, String item_Spec, String item_Add) {
		super();
		Item_Code = item_Code;
		Item_List_Code = item_List_Code;
		Item_Name = item_Name;
		Item_Price = item_Price;
		Item_Image = item_Image;
		Item_Category = item_Category;
		Item_Spec = item_Spec;
		Item_Add = item_Add;
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
	public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}
	public int getItem_Price() {
		return Item_Price;
	}
	public void setItem_Price(int item_Price) {
		Item_Price = item_Price;
	}
	public int getItem_Image() {
		return Item_Image;
	}
	public void setItem_Image(int item_Image) {
		Item_Image = item_Image;
	}
	public String getItem_Category() {
		return Item_Category;
	}
	public void setItem_Category(String item_Category) {
		Item_Category = item_Category;
	}
	public String getItem_Spec() {
		return Item_Spec;
	}
	public void setItem_Spec(String item_Spec) {
		Item_Spec = item_Spec;
	}
	public String getItem_Add() {
		return Item_Add;
	}
	public void setItem_Add(String item_Add) {
		Item_Add = item_Add;
	}
	@Override
	public String toString() {
		return "ItemDTO [Item_Code=" + Item_Code + ", Item_List_Code=" + Item_List_Code + ", Item_Name=" + Item_Name
				+ ", Item_Price=" + Item_Price + ", Item_Image=" + Item_Image + ", Item_Category=" + Item_Category
				+ ", Item_Spec=" + Item_Spec + ", Item_Add=" + Item_Add + "]";
	}
	
}//end class
