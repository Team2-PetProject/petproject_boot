package com.example.Item.dto;

import org.apache.ibatis.type.Alias;

@Alias("OptionTypeDTO")
public class OptionTypeDTO {

	private Integer tyCd;
	private Integer itCd;
	private String tyNm;

	public Integer getTyCd() {
		return tyCd;
	}

	public void setTyCd(Integer tyCd) {
		this.tyCd = tyCd;
	}

	public Integer getItCd() {
		return itCd;
	}

	public void setItCd(Integer idCd) {
		this.itCd = idCd;
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
		builder.append(itCd);
		builder.append(", tyNm=");
		builder.append(tyNm);
		builder.append("]");
		return builder.toString();
	}

}
