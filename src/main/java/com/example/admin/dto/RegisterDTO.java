package com.example.admin.dto;

public class RegisterDTO {
	private Integer itCd;
	private Integer optCd;
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public Integer getOptCd() {
		return optCd;
	}
	public void setOptCd(Integer optCd) {
		this.optCd = optCd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterDTO [itCd=");
		builder.append(itCd);
		builder.append(", optCd=");
		builder.append(optCd);
		builder.append("]");
		return builder.toString();
	}
	
}