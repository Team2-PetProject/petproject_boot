package com.example.dto;
public class CartInfoDTO {
	private int Cart_Code;
	private String Member_Code;
	private String Cart_Amount;
	private String Cart_Size;
	private String Cart_Color;
	private String Cart_Taste;
	private String Item_Code;
	private String Item_Category;
	private String Item_Name;
	private int Item_Price;
	private String Item_Image;
	private String Item_Size;
	private String Item_Color;
	private String Item_Taste;
	public CartInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartInfoDTO(int cart_Code, String member_Code, String cart_Amount, String cart_Size, String cart_Color,
			String cart_Taste, String item_Code, String item_Category, String item_Name, 
			int item_Price, String item_Image, String item_Size, String item_Color, String item_Taste) {

		super();
		Cart_Code = cart_Code;
		Member_Code = member_Code;
		Cart_Amount = cart_Amount;
		Cart_Size = cart_Size;
		Cart_Color = cart_Color;
		Cart_Taste = cart_Taste;
		Item_Code = item_Code;
		Item_Category = item_Category;
		Item_Name = item_Name;
		Item_Price = item_Price;
		Item_Image = item_Image;
		Item_Size = item_Size;
		Item_Color = item_Color;
		Item_Taste = item_Taste;
	}
	public int getCart_Code() {
		return Cart_Code;
	}
	public void setCart_Code(int cart_Code) {
		Cart_Code = cart_Code;
	}
	public String getMember_Code() {
		return Member_Code;
	}
	public void setMember_Code(String member_Code) {
		Member_Code = member_Code;
	}
	public String getCart_Amount() {
		return Cart_Amount;
	}
	public void setCart_Amount(String cart_Amount) {
		Cart_Amount = cart_Amount;
	}
	public String getCart_Size() {
		return Cart_Size;
	}
	public void setCart_Size(String cart_Size) {
		Cart_Size = cart_Size;
	}
	public String getCart_Color() {
		return Cart_Color;
	}
	public void setCart_Color(String cart_Color) {
		Cart_Color = cart_Color;
	}
	public String getCart_Taste() {
		return Cart_Taste;
	}
	public void setCart_Taste(String cart_Taste) {
		Cart_Taste = cart_Taste;
	}
	public String getItem_Code() {
		return Item_Code;
	}
	public void setItem_Code(String item_Code) {
		Item_Code = item_Code;
	}
	public String getItem_Category() {
		return Item_Category;
	}
	public void setItem_Category(String item_Category) {
		Item_Category = item_Category;
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
	public String getItem_Image() {
		return Item_Image;
	}
	public void setItem_Image(String item_Image) {
		Item_Image = item_Image;
	}
	public String getItem_Size() {
		return Item_Size;
	}
	public void setItem_Size(String item_Size) {
		Item_Size = item_Size;
	}
	public String getItem_Color() {
		return Item_Color;
	}
	public void setItem_Color(String item_Color) {
		Item_Color = item_Color;
	}
	public String getItem_Taste() {
		return Item_Taste;
	}
	public void setItem_Taste(String item_Taste) {
		Item_Taste = item_Taste;
	}
	@Override
	public String toString() {
		return "CartInfoDTO [Cart_Code=" + Cart_Code + ", Member_Code=" + Member_Code + ", Cart_Amount=" + Cart_Amount
				+ ", Cart_Size=" + Cart_Size + ", Cart_Color=" + Cart_Color + ", Cart_Taste=" + Cart_Taste
				+ ", Item_Code=" + Item_Code + ", Item_Category=" + Item_Category + ", Item_Name=" + Item_Name
				+ ", Item_Price=" + Item_Price + ", Item_Image=" + Item_Image
				+ ", Item_Size=" + Item_Size + ", Item_Color=" + Item_Color + ", Item_Taste=" + Item_Taste + "]";

	}
	
	
}
