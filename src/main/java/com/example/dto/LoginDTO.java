package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("LoginDTO")
public class LoginDTO {
	
	private String mbId;
	private String pw;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginDTO [mbId=");
		builder.append(mbId);
		builder.append(", pw=");
		builder.append(pw);
		builder.append("]");
		return builder.toString();
	}
	
	
}

