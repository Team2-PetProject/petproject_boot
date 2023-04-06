package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("MemberItemDTO")
public class MemberItemDTO {
	private String mbID;
	private Integer itCd;
	public String getMbID() {
		return mbID;
	}
	public void setMbID(String mbID) {
		this.mbID = mbID;
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
		builder.append("MemberItemDTO [mbID=");
		builder.append(mbID);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append("]");
		return builder.toString();
	}
	
}
