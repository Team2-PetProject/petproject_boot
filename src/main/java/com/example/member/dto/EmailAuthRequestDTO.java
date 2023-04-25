package com.example.member.dto;

import org.apache.ibatis.type.Alias;

@Alias("EmailAuthRequestDTO")
public class EmailAuthRequestDTO {
	
	private String mbId;
	private String pw;
	private String email1;
	private String email2;
	
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailAuthRequestDTO [mbId=");
		builder.append(mbId);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", email1=");
		builder.append(email1);
		builder.append(", email2=");
		builder.append(email2);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
