package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("OrderInfoDTO")
public class OrderInfoDTO {
	private int OrderInfo_Code;
	private int OrderInfo_Delivery;
	private String Member_Code;
	private String OrderInfo_OrderName;
	private String OrderInfo_Post;
	private String OrderInfo_Addr1;
	private String OrderInfo_Addr2;
	private String OrderInfo_Phone;
	private String OrderInfo_PayMethod;
	private String OrderInfo_OrderDay;
	public OrderInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderInfoDTO(int orderInfo_Code, String member_Code, String orderInfo_OrderName, String orderInfo_Post,
			String orderInfo_Addr1, String orderInfo_Addr2, String orderInfo_Phone, String orderInfo_PayMethod,
			String orderInfo_OrderDay, int orderInfo_Delivery) {
		super();
		OrderInfo_Code = orderInfo_Code;
		Member_Code = member_Code;
		OrderInfo_OrderName = orderInfo_OrderName;
		OrderInfo_Post = orderInfo_Post;
		OrderInfo_Addr1 = orderInfo_Addr1;
		OrderInfo_Addr2 = orderInfo_Addr2;
		OrderInfo_Phone = orderInfo_Phone;
		OrderInfo_PayMethod = orderInfo_PayMethod;
		OrderInfo_OrderDay = orderInfo_OrderDay;
		OrderInfo_Delivery = orderInfo_Delivery;
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
	public String getOrderInfo_OrderName() {
		return OrderInfo_OrderName;
	}
	public void setOrderInfo_OrderName(String orderInfo_OrderName) {
		OrderInfo_OrderName = orderInfo_OrderName;
	}
	public String getOrderInfo_Post() {
		return OrderInfo_Post;
	}
	public void setOrderInfo_Post(String orderInfo_Post) {
		OrderInfo_Post = orderInfo_Post;
	}
	public String getOrderInfo_Addr1() {
		return OrderInfo_Addr1;
	}
	public void setOrderInfo_Addr1(String orderInfo_Addr1) {
		OrderInfo_Addr1 = orderInfo_Addr1;
	}
	public String getOrderInfo_Addr2() {
		return OrderInfo_Addr2;
	}
	public void setOrderInfo_Addr2(String orderInfo_Addr2) {
		OrderInfo_Addr2 = orderInfo_Addr2;
	}
	public String getOrderInfo_Phone() {
		return OrderInfo_Phone;
	}
	public void setOrderInfo_Phone(String orderInfo_Phone) {
		OrderInfo_Phone = orderInfo_Phone;
	}
	public String getOrderInfo_PayMethod() {
		return OrderInfo_PayMethod;
	}
	public void setOrderInfo_PayMethod(String orderInfo_PayMethod) {
		OrderInfo_PayMethod = orderInfo_PayMethod;
	}
	public String getOrderInfo_OrderDay() {
		return OrderInfo_OrderDay;
	}
	public void setOrderInfo_OrderDay(String orderInfo_OrderDay) {
		OrderInfo_OrderDay = orderInfo_OrderDay;
	}
	public int getOrderInfo_Delivery() {
		return OrderInfo_Delivery;
	}
	public void setOrderInfo_Delivery(int orderInfo_Delivery) {
		OrderInfo_Delivery = orderInfo_Delivery;
	}
	@Override
	public String toString() {
		return "OrderInfoDTO [OrderInfo_Code=" + OrderInfo_Code + ", Member_Code=" + Member_Code
				+ ", OrderInfo_OrderName=" + OrderInfo_OrderName + ", OrderInfo_Post=" + OrderInfo_Post
				+ ", OrderInfo_Addr1=" + OrderInfo_Addr1 + ", OrderInfo_Addr2=" + OrderInfo_Addr2 + ", OrderInfo_Phone="
				+ OrderInfo_Phone + ", OrderInfo_PayMethod=" + OrderInfo_PayMethod + ", OrderInfo_OrderDay="
				+ OrderInfo_OrderDay + ", OrderInfo_Delivery=" + OrderInfo_Delivery + "]";
	}
	 
}
