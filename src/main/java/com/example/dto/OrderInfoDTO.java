package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("OrderInfoDTO")
public class OrderInfoDTO {
	private Integer ordCd;
	private Integer dlvyCd;
	private String ordNm;
	private Integer ordPost;
	private String ordAddr1;
	private String ordAddr2;
	private String ordTel;
	private String payMethod;
	private String payTm;
	public Integer getOrdCd() {
		return ordCd;
	}
	public void setOrdCd(Integer ordCd) {
		this.ordCd = ordCd;
	}
	public Integer getDlvyCd() {
		return dlvyCd;
	}
	public void setDlvyCd(Integer dlvyCd) {
		this.dlvyCd = dlvyCd;
	}
	public String getOrdNm() {
		return ordNm;
	}
	public void setOrdNm(String ordNm) {
		this.ordNm = ordNm;
	}
	public Integer getOrdPost() {
		return ordPost;
	}
	public void setOrdPost(Integer ordPost) {
		this.ordPost = ordPost;
	}
	public String getOrdAddr1() {
		return ordAddr1;
	}
	public void setOrdAddr1(String ordAddr1) {
		this.ordAddr1 = ordAddr1;
	}
	public String getOrdAddr2() {
		return ordAddr2;
	}
	public void setOrdAddr2(String ordAddr2) {
		this.ordAddr2 = ordAddr2;
	}
	public String getOrdTel() {
		return ordTel;
	}
	public void setOrdTel(String ordTel) {
		this.ordTel = ordTel;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getPayTm() {
		return payTm;
	}
	public void setPayTm(String payTm) {
		this.payTm = payTm;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderInfoDTO [ordCd=");
		builder.append(ordCd);
		builder.append(", dlvyCd=");
		builder.append(dlvyCd);
		builder.append(", ordNm=");
		builder.append(ordNm);
		builder.append(", ordPost=");
		builder.append(ordPost);
		builder.append(", ordAddr1=");
		builder.append(ordAddr1);
		builder.append(", ordAddr2=");
		builder.append(ordAddr2);
		builder.append(", ordTel=");
		builder.append(ordTel);
		builder.append(", payMethod=");
		builder.append(payMethod);
		builder.append(", payTm=");
		builder.append(payTm);
		builder.append("]");
		return builder.toString();
	}
	
	
}
