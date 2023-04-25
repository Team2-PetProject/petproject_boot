package com.example.CartOrder.dto;

import org.apache.ibatis.type.Alias;

@Alias("TotalDayOrderCountDTO")
public class TotalDayOrderCountDTO {

	private String mbId;
	private String itNm;

	public String getMbId() {
		return mbId;
	}

	public String getItNm() {
		return itNm;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public void setItNm(String itNm) {
		this.itNm = itNm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("totalDayOrderCountDTO [mbId=");
		builder.append(mbId);
		builder.append(", itNm=");
		builder.append(itNm);
		builder.append("]");
		return builder.toString();
	}

}
