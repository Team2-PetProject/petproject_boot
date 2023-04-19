package com.example.CartOrder.dto;

import org.apache.ibatis.type.Alias;

@Alias("CartSearchUnableDTO")
public class CartSearchUnableDTO {
	private String mbId;
	private Integer amount = 0;
	private Integer cartCd;

	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public Integer getCartCd() {
		return cartCd;
	}
	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartSearchUnableDTO [mbId=");
		builder.append(mbId);
		builder.append(", cartCd=");
		builder.append(cartCd);
		builder.append("]");
		return builder.toString();
	}



}