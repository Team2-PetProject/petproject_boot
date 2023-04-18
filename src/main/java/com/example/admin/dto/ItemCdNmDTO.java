package com.example.admin.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemCdNmDTO")
public class ItemCdNmDTO {
	private Integer itCd;
	private String itNm;
	private String cat; 
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemCdNmDTO [itCd=");
		builder.append(itCd);
		builder.append(", itNm=");
		builder.append(itNm);
		builder.append(", category=");
		builder.append(cat);
		builder.append("]");
		return builder.toString();
	}
	public String getCategory() {
		return cat;
	}
	public void setCategory(String category) {
		this.cat = category;
	}
	
	
}
