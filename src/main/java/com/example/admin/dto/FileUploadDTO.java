package com.example.admin.dto;

import java.util.Arrays;

import org.apache.ibatis.type.Alias;

@Alias("FileUploadDTO")
public class FileUploadDTO {
	private Integer imgCd;
	private String imgNm;
	private String sz;
	private String upTm;
	private String di;
	private byte[] fl;
	public Integer getImgCd() {
		return imgCd;
	}
	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
	}
	public String getImgNm() {
		return imgNm;
	}
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	public String getSz() {
		return sz;
	}
	public void setSz(String sz) {
		this.sz = sz;
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
	public void setDi(String dl) {
		this.di = dl;
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
		builder.append("FileUploadDTO [imgCd=");
		builder.append(imgCd);
		builder.append(", imgNm=");
		builder.append(imgNm);
		builder.append(", sz=");
		builder.append(sz);
		builder.append(", upTm=");
		builder.append(upTm);
		builder.append(", dl=");
		builder.append(di);
		builder.append(", fl=");
		builder.append(Arrays.toString(fl));
		builder.append("]");
		return builder.toString();
	}
	public void updateDetailFile(ItemInfoDTO itemInfoDTO) {
		// TODO Auto-generated method stub
		
	}
	
}