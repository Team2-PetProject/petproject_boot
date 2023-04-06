package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("TypeDTO")
public class TypeDTO {
	private Integer tyCd;
	private String tyNm;
	public Integer getTyCd() {
		return tyCd;
	}
	public void setTyCd(Integer tyCd) {
		this.tyCd = tyCd;
	}
	public String getTyNm() {
		return tyNm;
	}
	public void setTyNm(String tyNm) {
		this.tyNm = tyNm;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TypeDTO [tyCd=");
		builder.append(tyCd);
		builder.append(", tyNm=");
		builder.append(tyNm);
		builder.append("]");
		return builder.toString();
	}
	
}