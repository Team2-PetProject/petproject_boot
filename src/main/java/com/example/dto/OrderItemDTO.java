package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("OrderHistoryPageDTO")
public class OrderItemDTO {
	private int OrderItem_Code;
	private int OrderInfo_Code;
	private String Member_Code;
	private int Item_Code;
	private int Item_List_Code;
	private int Item_Amount;
	private String Item_Category;
	private int Item_Price;
	private int Item_Image;
	private String Item_Spec;
	
	public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDTO(int orderItem_Code, int orderInfo_Code, String member_Code, int item_Code, int item_List_Code,
			int item_Amount, String item_Category, int item_Price, int item_Image, String item_Spec) {
		super();
		OrderItem_Code = orderItem_Code;
		OrderInfo_Code = orderInfo_Code;
		Member_Code = member_Code;
		Item_Code = item_Code;
		Item_List_Code = item_List_Code;
		Item_Amount = item_Amount;
		Item_Category = item_Category;
		Item_Price = item_Price;
		Item_Image = item_Image;
		Item_Spec = item_Spec;
	}

	public int getOrderItem_Code() {
		return OrderItem_Code;
	}

	public void setOrderItem_Code(int orderItem_Code) {
		OrderItem_Code = orderItem_Code;
	}

	public int getOrderInfo_Code() {
		return OrderInfo_Code;
	}

	public void setOrderInfo_Code(int orderInfo_Code) {
		OrderInfo_Code = orderInfo_Code;
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

	public String getItem_Category() {
		return Item_Category;
	}

	public void setItem_Category(String item_Category) {
		Item_Category = item_Category;
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

	public String getItem_Spec() {
		return Item_Spec;
	}

	public void setItem_Spec(String item_Spec) {
		Item_Spec = item_Spec;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [OrderItem_Code=" + OrderItem_Code + ", OrderInfo_Code=" + OrderInfo_Code
				+ ", Member_Code=" + Member_Code + ", Item_Code=" + Item_Code + ", Item_List_Code=" + Item_List_Code
				+ ", Item_Amount=" + Item_Amount + ", Item_Category=" + Item_Category + ", Item_Price=" + Item_Price
				+ ", Item_Image=" + Item_Image + ", Item_Spec=" + Item_Spec + "]";
	}
	
}
