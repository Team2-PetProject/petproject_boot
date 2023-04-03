package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemDTO")
public class ItemDTO {
	private Integer itCd;
	private Integer imgCd;
	private String itNm;
	private Integer price;
	private String cat;
	private String optAdd;
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
	public String getOptAdd() {
		return optAdd;
	}
	public void setOptAdd(String optAdd) {
		this.optAdd = optAdd;
	}
	
	
	
}//end class
