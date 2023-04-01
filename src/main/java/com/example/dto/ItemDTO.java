package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemDTO")
public class ItemDTO {
	private int itemcode;
	private int itemlistcode;
	private String itemname;
	private int itemprice;
	private int itemimage;
	private String itemcategory;
	private String itemspec;
	private String itemadd;
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getItem_Code() {
		return itemcode;
	}
	
	public void setItem_Code(int item_Code) {
		itemcode = item_Code;
	}
	
	public int getItem_List_Code() {
		return itemlistcode;
	}
	
	public void setItem_List_Code(int item_List_Code) {
		itemlistcode = item_List_Code;
	}
	
	public String getItem_Name() {
		return itemname;
	}
	
	public void setItem_Name(String item_Name) {
		itemname = item_Name;
	}
	
	public int getItem_Price() {
		return itemprice;
	}
	
	public void setItem_Price(int item_Price) {
		itemprice = item_Price;
	}
	
	public int getItem_Image() {
		return itemimage;
	}
	
	public void setItem_Image(int item_Image) {
		itemimage = item_Image;
	}
	
	public String getItem_Category() {
		return itemcategory;
	}
	
	public void setItem_Category(String item_Category) {
		itemcategory = item_Category;
	}
	
	public String getItem_Spec() {
		return itemspec;
	}
	
	public void setItem_Spec(String item_Spec) {
		itemspec = item_Spec;
	}
	
	public String getItem_Add() {
		return itemadd;
	}
	
	public void setItem_Add(String item_Add) {
		itemadd = item_Add;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTO [itemcode=");
		builder.append(itemcode);
		builder.append(", itemlistcode=");
		builder.append(itemlistcode);
		builder.append(", itemname=");
		builder.append(itemname);
		builder.append(", itemprice=");
		builder.append(itemprice);
		builder.append(", itemimage=");
		builder.append(itemimage);
		builder.append(", itemcategory=");
		builder.append(itemcategory);
		builder.append(", itemspec=");
		builder.append(itemspec);
		builder.append(", itemadd=");
		builder.append(itemadd);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}//end class
