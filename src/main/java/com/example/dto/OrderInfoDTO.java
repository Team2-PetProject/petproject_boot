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
	private String payMeth;
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
	public String getPayMeth() {
		return payMeth;
	}
	public void setPayMeth(String payMeth) {
		this.payMeth = payMeth;
	}
	public String getPayTm() {
		return payTm;
	}
	public void setPayTm(String payTm) {
		this.payTm = payTm;
	}



}