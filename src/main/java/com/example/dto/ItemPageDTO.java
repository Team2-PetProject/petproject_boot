package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemPageDTO")
public class ItemPageDTO {

	private Integer itCd;
	private Integer imgCd;
	private String itNm;
	private Integer price;
	private String cat;
	private Integer tyCd;
	private String  perPage;
	private String startIdx;
	private String endIdx;
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public Integer getImgCd() {
		return imgCd;
	}
	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
	}
	public String getItNm() {
		return itNm;
	}
	public void setItNm(String itNm) {
		this.itNm = itNm;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public Integer getTyCd() {
		return tyCd;
	}
	public void setTyCd(Integer tyCd) {
		this.tyCd = tyCd;
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
		builder.append("ItemDTO [itCd=");
		builder.append(itCd);
		builder.append(", imgCd=");
		builder.append(imgCd);
		builder.append(", itNm=");
		builder.append(itNm);
		builder.append(", price=");
		builder.append(price);
		builder.append(", cat=");
		builder.append(cat);
		builder.append(", tyCd=");
		builder.append(tyCd);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", startIdx=");
		builder.append(startIdx);
		builder.append(", endIdx=");
		builder.append(endIdx);
		builder.append("]");
		return builder.toString();
	}




}//end class