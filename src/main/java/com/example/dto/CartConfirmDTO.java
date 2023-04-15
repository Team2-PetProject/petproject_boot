package com.example.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("CartConfirmDTO")
public class CartConfirmDTO {
	private Integer cartCd;
	private Integer itCd;
	private String itNm;
	private Integer imgCd;
	private Integer price;
	private Integer amount;
	private Integer mbId;
	private Integer optCd;
	private String optNm;
	private List<ArrayOptCdDTO> optCds;
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
	public String getItNm() {
		return itNm;
	}
	public void setItNm(String itNm) {
		this.itNm = itNm;
	}
	public Integer getImgCd() {
		return imgCd;
	}
	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getMbId() {
		return mbId;
	}
	public void setMbId(Integer mbId) {
		this.mbId = mbId;
	}
	public Integer getOptCd() {
		return optCd;
	}
	public void setOptCd(Integer optCd) {
		this.optCd = optCd;
	}
	public String getOptNm() {
		return optNm;
	}
	public void setOptNm(String optNm) {
		this.optNm = optNm;
	}
	public List<ArrayOptCdDTO> getOptCds() {
		return optCds;
	}
	public void setOptCds(List<ArrayOptCdDTO> optCds) {
		this.optCds = optCds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartConfirmDTO [cartCd=");
		builder.append(cartCd);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", itNm=");
		builder.append(itNm);
		builder.append(", imgCd=");
		builder.append(imgCd);
		builder.append(", price=");
		builder.append(price);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", optCd=");
		builder.append(optCd);
		builder.append(", optNm=");
		builder.append(optNm);
		builder.append(", optCds=");
		builder.append(optCds);
		builder.append("]");
		return builder.toString();
	}






}