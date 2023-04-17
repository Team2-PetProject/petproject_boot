package com.example.CartOrder.dto;

import org.apache.ibatis.type.Alias;

@Alias("ArrayOptCdDTO")
public class ArrayOptCdDTO {
private Integer optCd;
private Integer tyCd;
private String optNm;
public Integer getOptCd() {
	return optCd;
}
public void setOptCd(Integer optCd) {
	this.optCd = optCd;
}
public Integer getTyCd() {
	return tyCd;
}
public void setTyCd(Integer tyCd) {
	this.tyCd = tyCd;
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
	builder.append("ArrayOptCdDTO [optCd=");
	builder.append(optCd);
	builder.append(", tyCd=");
	builder.append(tyCd);
	builder.append(", optNm=");
	builder.append(optNm);
	builder.append("]");
	return builder.toString();
}



}