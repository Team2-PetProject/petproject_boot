package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("OrderSearchDTO")
public class OrderSearchDTO {
	private Integer cartCd;
	private Integer ordCd;
	private String mbId;
	private Integer itCd;
	private String itNm;
	private Integer amount;
	private String cat;
	private Integer price;
	private Integer imgCd;
	private Integer optNm;
	private String startDay;
	private String endDay;
	private String perPage;
	private String startIdx;
	private String endIdx;

	public Integer getCartCd() {
		return cartCd;
	}

	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}

	public String getItNm() {
		return itNm;
	}

	public void setItNm(String itNm) {
		this.itNm = itNm;
	}

	public Integer getOrdCd() {
		return ordCd;
	}

	public void setOrdCd(Integer ordCd) {
		this.ordCd = ordCd;
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

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
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

	public Integer getOptNm() {
		return optNm;
	}

	public void setOptNm(Integer optNm) {
		this.optNm = optNm;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getPerPage() {
		return perPage;
	}

	public void setPerPage(String perPage) {
		this.perPage = perPage;
	}

	public String getStartIdx() {
		return startIdx;
	}

	public void setStartIdx(String startIdx) {
		this.startIdx = startIdx;
	}

	public String getEndIdx() {
		return endIdx;
	}

	public void setEndIdx(String endIdx) {
		this.endIdx = endIdx;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderSearchDTO [cartCd=");
		builder.append(cartCd);
		builder.append(", ordCd=");
		builder.append(ordCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", itNm=");
		builder.append(itNm);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", cat=");
		builder.append(cat);
		builder.append(", price=");
		builder.append(price);
		builder.append(", imgCd=");
		builder.append(imgCd);
		builder.append(", optNm=");
		builder.append(optNm);
		builder.append(", startDay=");
		builder.append(startDay);
		builder.append(", endDay=");
		builder.append(endDay);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", startIdx=");
		builder.append(startIdx);
		builder.append(", endIdx=");
		builder.append(endIdx);
		builder.append("]");
		return builder.toString();
	}

}