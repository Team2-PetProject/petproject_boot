package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("ItemOptionDTO")
public class ItemOptionDTO {
	private Integer tyCd;
	private Integer idCd;
	private String tyNm;
	public Integer getTyCd() {
		return tyCd;
	}
	public void setTyCd(Integer tyCd) {
		this.tyCd = tyCd;
	}
	public Integer getIdCd() {
		return idCd;
	}
	public void setIdCd(Integer idCd) {
		this.idCd = idCd;
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
		builder.append("ItemOptionDTO [tyCd=");
		builder.append(tyCd);
		builder.append(", idCd=");
		builder.append(idCd);
		builder.append(", tyNm=");
		builder.append(tyNm);
		builder.append("]");
		return builder.toString();
	}
	
}
