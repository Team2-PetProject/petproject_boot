package com.example.CartOrder.dto;

import org.apache.ibatis.type.Alias;

@Alias("SearchResultDTO")
public class SearchResultDTO {

	private Integer cartCd;
	private Integer ordCd;
	private String mbId;
	private Integer itCd;
	private String itNm;
	private Integer amount;
	private String cat;
	private Integer price;
	private Integer imgCd;
	private String optNm;
	private Integer dlvyCd;
	private Integer curPage;
	private Integer totalPage;

	public Integer getCartCd() {
		return cartCd;
	}

	public Integer getOrdCd() {
		return ordCd;
	}

	public String getMbId() {
		return mbId;
	}

	public Integer getItCd() {
		return itCd;
	}

	public String getItNm() {
		return itNm;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCat() {
		return cat;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getImgCd() {
		return imgCd;
	}

	public String getOptNm() {
		return optNm;
	}

	public Integer getDlvyCd() {
		return dlvyCd;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}

	public void setOrdCd(Integer ordCd) {
		this.ordCd = ordCd;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}

	public void setItNm(String itNm) {
		this.itNm = itNm;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
	}

	public void setOptNm(String optNm) {
		this.optNm = optNm;
	}

	public void setDlvyCd(Integer dlvyCd) {
		this.dlvyCd = dlvyCd;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchResultDTO [cartCd=");
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
		builder.append(", dlvyCd=");
		builder.append(dlvyCd);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append("]");
		return builder.toString();
	}

}
