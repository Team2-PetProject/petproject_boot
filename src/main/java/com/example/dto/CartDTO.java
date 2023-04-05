package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("CartDTO")
public class CartDTO {
	private int Cart_Code;
	private int Item_Code;
	private String Member_Code;
	private int Item_List_Code;
	private int Item_Amount;
	private String Item_Spec;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(int cart_Code, int item_Code, String member_Code, int item_List_Code, int item_Amount,
			String item_Spec) {
		super();
		Cart_Code = cart_Code;
		Item_Code = item_Code;
		Member_Code = member_Code;
		Item_List_Code = item_List_Code;
		Item_Amount = item_Amount;
		Item_Spec = item_Spec;
	}
	public int getCart_Code() {
		return Cart_Code;
	}
	public void setCart_Code(int cart_Code) {
		Cart_Code = cart_Code;
	}
	public int getItem_Code() {
		return Item_Code;
	}
	public void setItem_Code(int item_Code) {
		Item_Code = item_Code;
	}
	public String getMember_Code() {
		return Member_Code;
	}
	public void setMember_Code(String member_Code) {
		Member_Code = member_Code;
	}
	public int getItem_List_Code() {
		return Item_List_Code;
	}
	public void setItem_List_Code(int item_List_Code) {
		Item_List_Code = item_List_Code;
	}
	public int getItem_Amount() {
		return Item_Amount;
	}
	public void setItem_Amount(int item_Amount) {
		Item_Amount = item_Amount;
	}
	public String getItem_Spec() {
		return Item_Spec;
	}
	public void setItem_Spec(String item_Spec) {
		Item_Spec = item_Spec;
	}
	@Override
	public String toString() {
		return "CartDTO [Cart_Code=" + Cart_Code + ", Item_Code=" + Item_Code + ", Member_Code=" + Member_Code
				+ ", Item_List_Code=" + Item_List_Code + ", Item_Amount=" + Item_Amount + ", Item_Spec=" + Item_Spec
				+ "]";
	}
	
}
