package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("SpecUpdateDTO")
public class SpecUpdateDTO {

	private String	mbId;
	private Integer	optCd;
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
	public Integer getOptCd() {
		return optCd;
	}
	public void setOptCd(Integer optCd) {
		this.optCd = optCd;
	}


}
