package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("CartDTO")
public class CartDTO {
	private Integer cartCd;
	private Integer itCd;
	private String mbId;
	private Integer amount;
	private Integer optCd;

	public Integer getCartCd() {
		return cartCd;
	}
	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getOptCd() {
		return optCd;
	}
	public void setOptCd(Integer optCd) {
		this.optCd = optCd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartDTO [cartCd=");
		builder.append(cartCd);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", optCd=");
		builder.append(optCd);
		builder.append("]");
		return builder.toString();
	}




}