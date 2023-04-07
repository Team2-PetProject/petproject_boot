package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("CartDTO")
public class CartDTO {
	private Integer cartCd;
	private Integer itCd;
	private String mbId;
	private Integer amount;
	private String optAdd;
	private String optCd;
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
	public String getOptAdd() {
		return optAdd;
	}
	public void setOptAdd(String optAdd) {
		this.optAdd = optAdd;
	}
	
	public String getOptCd() {
		return optCd;
	}
	public void setOptCd(String optCd) {
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
		builder.append(", optAdd=");
		builder.append(optAdd);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
