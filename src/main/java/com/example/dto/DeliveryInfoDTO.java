package com.example.dto;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("DeliveryInfoDTO")
@Schema(description = "배송정보")
public class DeliveryInfoDTO {
	@Schema(description = "배송 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer dlvyCd;
	@Schema(description = "회사명", example="", required = true, minLength = 1, maxLength = 50)
	private String com;
	@Schema(description = "배송장", example="123456", required = true, minLength = 1, maxLength = 50)
	private String inv;
	@Schema(description = "배송시작일", example="2023-03-01", required = true, minLength = 1, maxLength = 50)
	private String dlvyStart;
	@Schema(description = "배송종료일", example="2023-03-01", required = true, minLength = 1, maxLength = 50)
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