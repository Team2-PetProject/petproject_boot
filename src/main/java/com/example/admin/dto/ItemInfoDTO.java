package com.example.admin.dto;

import java.util.Arrays;

import org.apache.ibatis.type.Alias;

@Alias("ItemInfoDTO")
public class ItemInfoDTO {
	private Integer itInfoCd;
	private Integer itCd;
	private String imgNm;
	private String upTm;
	private String di;
	private byte[] fl;
	private long sz;
	public Integer getItInfoCd() {
		return itInfoCd;
	}
	public void setItInfoCd(Integer itInfoCd) {
		this.itInfoCd = itInfoCd;
	}
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public String getImgNm() {
		return imgNm;
	}
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	public String getUpTm() {
		return upTm;
	}
	public void setUpTm(String upTm) {
		this.upTm = upTm;
	}
	public String getDi() {
		return di;
	}
	public void setDi(String di) {
		this.di = di;
	}
	public byte[] getFl() {
		return fl;
	}
	public void setFl(byte[] fl) {
		this.fl = fl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemInfoDTO [itInfoCd=");
		builder.append(itInfoCd);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", imgNm=");
		builder.append(imgNm);
		builder.append(", upTm=");
		builder.append(upTm);
		builder.append(", di=");
		builder.append(di);
		builder.append(", fl=");
		builder.append(Arrays.toString(fl));
		builder.append("]");
		return builder.toString();
	}
	public long getSz() {
		return sz;
	}
	public void setSz(long sz) {
		this.sz = sz;
	}
	
}
