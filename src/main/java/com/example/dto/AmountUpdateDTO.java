package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("AmountUpdateDTO")
public class AmountUpdateDTO {

	private String	mbId;
	private Integer	amount;
	private Integer cartCd;


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
	public Integer getCartCd() {
		return cartCd;
	}
	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}



}
