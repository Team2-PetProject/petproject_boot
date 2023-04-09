package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("SearchResultDTO")
public class SearchResultDTO {
	private Integer cartCd;
	private Integer OrdCd;
	private String mbId;
	private Integer itCd;
	private String itNm;
	private Integer amount;
	private String cat;
	private Integer price;
	private Integer imgCd;
	private Integer optNm;
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
	public String getItNm() {
		return itNm;
	}
	public void setItNm(String itNm) {
		this.itNm = itNm;
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


}
