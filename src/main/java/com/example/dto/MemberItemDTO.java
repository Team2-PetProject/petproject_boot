package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("MemberItemDTO")
public class MemberItemDTO {
	private String mbId;
	private Integer itCd;

	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberItemDTO [mbId=");
		builder.append(mbId);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append("]");
		return builder.toString();
	}

}