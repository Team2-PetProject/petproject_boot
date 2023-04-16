package com.example.dto;

import java.sql.Timestamp;

public class UpTmDTO {

	private Integer dlvyCd;
	private Timestamp dlvyEnd;
	public Integer getDlvyCd() {
		return dlvyCd;
	}
	public void setDlvyCd(Integer dlvyCd) {
		this.dlvyCd = dlvyCd;
	}
	public Timestamp getDlvyEnd() {
		return dlvyEnd;
	}
	public void setDlvyEnd(Timestamp dlvyEnd) {
		this.dlvyEnd = dlvyEnd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpTmDTO [dlvyCd=");
		builder.append(dlvyCd);
		builder.append(", dlvyEnd=");
		builder.append(dlvyEnd);
		builder.append("]");
		return builder.toString();
	}




}
