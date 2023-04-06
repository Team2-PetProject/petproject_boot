package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("DeliveryInfoDTO")
public class DeliveryInfoDTO {
	private Integer dlvyCd;
	private String com;
	private String inv;
	private String dlvyStart;
	private String dlvyEnd;
	public Integer getDlvyCd() {
		return dlvyCd;
	}
	public void setDlvyCd(Integer dlvyCd) {
		this.dlvyCd = dlvyCd;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getInv() {
		return inv;
	}
	public void setInv(String inv) {
		this.inv = inv;
	}
	public String getDlvyStart() {
		return dlvyStart;
	}
	public void setDlvyStart(String dlvyStart) {
		this.dlvyStart = dlvyStart;
	}
	public String getDlvyEnd() {
		return dlvyEnd;
	}
	public void setDlvyEnd(String dlvyEnd) {
		this.dlvyEnd = dlvyEnd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryInfoDTO [dlvyCd=");
		builder.append(dlvyCd);
		builder.append(", com=");
		builder.append(com);
		builder.append(", inv=");
		builder.append(inv);
		builder.append(", dlvyStart=");
		builder.append(dlvyStart);
		builder.append(", dlvyEnd=");
		builder.append(dlvyEnd);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}