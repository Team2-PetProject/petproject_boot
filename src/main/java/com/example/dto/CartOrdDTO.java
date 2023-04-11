package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("CartOrdDTO")
public class CartOrdDTO {
	private Integer  tItCd;
	private Integer cartCd;
	private Integer OrdCd;
	private String mbId;
	private Integer itCd;
	private Integer amount;
	private Integer price;
	private Integer imgCd;
	private Integer optCd;



	public Integer gettItCd() {
		return tItCd;
	}



	public void settItCd(Integer tItCd) {
		this.tItCd = tItCd;
	}



	public Integer getCartCd() {
		return cartCd;
	}



	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}



	public Integer getOrdCd() {
		return OrdCd;
	}



	public void setOrdCd(Integer ordCd) {
		OrdCd = ordCd;
	}



	public String getMbId() {
		return mbId;
	}



	public void setMbId(String mbId) {
		this.mbId = mbId;
	}



	public Integer getItCd() {
		return itCd;
	}



	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public Integer getImgCd() {
		return imgCd;
	}



	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
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
		builder.append("CartOrdDTO [tItCd=");
		builder.append(tItCd);
		builder.append(", cartCd=");
		builder.append(cartCd);
		builder.append(", OrdCd=");
		builder.append(OrdCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", price=");
		builder.append(price);
		builder.append(", imgCd=");
		builder.append(imgCd);
		builder.append(", optCd=");
		builder.append(optCd);
		builder.append("]");
		return builder.toString();
	}


}