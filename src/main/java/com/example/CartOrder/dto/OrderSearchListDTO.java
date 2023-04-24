package com.example.CartOrder.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("OrderSearchListDTO")

public class OrderSearchListDTO {

	private Integer tItCd;
	private Integer cartCd;
	private Integer itCd;
	private String itNm;
	private Integer dlvyCd;
	private Integer imgCd;
	private String mbId;
	private Integer price;
	private Integer amount;
	private Date payTm;
	private String optNm;

	public Integer gettItCd() {
		return tItCd;
	}
	public Integer getCartCd() {
		return cartCd;
	}
	public Integer getItCd() {
		return itCd;
	}
	public String getItNm() {
		return itNm;
	}
	public Integer getDlvyCd() {
		return dlvyCd;
	}
	public Integer getImgCd() {
		return imgCd;
	}
	public String getMbId() {
		return mbId;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getAmount() {
		return amount;
	}
	public Date getPayTm() {
		return payTm;
	}
	public String getOptNm() {
		return optNm;
	}
	public void settItCd(Integer tItCd) {
		this.tItCd = tItCd;
	}
	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public void setItNm(String itNm) {
		this.itNm = itNm;
	}
	public void setDlvyCd(Integer dlvyCd) {
		this.dlvyCd = dlvyCd;
	}
	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public void setPayTm(Date payTm) {
		this.payTm = payTm;
	}
	public void setOptNm(String optNm) {
		this.optNm = optNm;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderSearchListDTO [tItCd=");
		builder.append(tItCd);
		builder.append(", cartCd=");
		builder.append(cartCd);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", itNm=");
		builder.append(itNm);
		builder.append(", dlvyCd=");
		builder.append(dlvyCd);
		builder.append(", imgCd=");
		builder.append(imgCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", price=");
		builder.append(price);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", payTm=");
		builder.append(payTm);
		builder.append(", optNm=");
		builder.append(optNm);
		builder.append("]");
		return builder.toString();
	}

}
