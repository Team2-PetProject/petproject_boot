package com.example.dto;

public class RegisterDTO {

	private Integer itCd;
	private Integer tyCd;

	public Integer getItCd() {
		return itCd;
	}

	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}

	public Integer getTyCd() {
		return tyCd;
	}

	public void setTyCd(Integer tyCd) {
		this.tyCd = tyCd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterDTO [itCd=");
		builder.append(itCd);
		builder.append(", tyCd=");
		builder.append(tyCd);
		builder.append("]");
		return builder.toString();
	}

}
