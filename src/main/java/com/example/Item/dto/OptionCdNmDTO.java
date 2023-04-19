package com.example.Item.dto;

import org.apache.ibatis.type.Alias;

@Alias("OptionCdNmDTO")
public class OptionCdNmDTO {
	private Integer optCd;
	private String optNm;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OptionCdNmDTO [optCd=");
		builder.append(optCd);
		builder.append(", optNm=");
		builder.append(optNm);
		builder.append("]");
		return builder.toString();
	}
	
}
