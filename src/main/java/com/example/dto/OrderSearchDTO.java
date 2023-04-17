package com.example.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("OrderSearchDTO")
public class OrderSearchDTO {

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
	private Integer perPage;
	private Integer totalPage;
	private Integer startIdx;
	private Integer endIdx;
	private String startDay;
	private String endDay;
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
	public Integer getDlvyCd() {
		return dlvyCd;
	}
	public void setDlvyCd(Integer dlvyCd) {
		this.dlvyCd = dlvyCd;
	}
	public Integer getImgCd() {
		return imgCd;
	}
	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
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
	public Date getPayTm() {
		return payTm;
	}
	public void setPayTm(Date payTm) {
		this.payTm = payTm;
	}
	public String getOptNm() {
		return optNm;
	}
	public void setOptNm(String optNm) {
		this.optNm = optNm;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(Integer startIdx) {
		this.startIdx = startIdx;
	}
	public Integer getEndIdx() {
		return endIdx;
	}
	public void setEndIdx(Integer endIdx) {
		this.endIdx = endIdx;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderSearchDTO [tItCd=");
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
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append(", startIdx=");
		builder.append(startIdx);
		builder.append(", endIdx=");
		builder.append(endIdx);
		builder.append(", startDay=");
		builder.append(startDay);
		builder.append(", endDay=");
		builder.append(endDay);
		builder.append("]");
		return builder.toString();
	}




	}