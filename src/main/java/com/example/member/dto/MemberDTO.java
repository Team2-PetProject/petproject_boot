package com.example.member.dto;

import org.apache.ibatis.type.Alias;

@Alias("MemberDTO")
public class MemberDTO {

	private String mbId;
	private String pw;
	private String nm;
	private String post;
	private String addr1;
	private String addr2;
	private String tel1;
	private String tel2;
	private String tel3;
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

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
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
		builder.append("MemberDTO [mbId=");
		builder.append(mbId);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", nm=");
		builder.append(nm);
		builder.append(", post=");
		builder.append(post);
		builder.append(", addr1=");
		builder.append(addr1);
		builder.append(", addr2=");
		builder.append(addr2);
		builder.append(", tel1=");
		builder.append(tel1);
		builder.append(", tel2=");
		builder.append(tel2);
		builder.append(", tel3=");
		builder.append(tel3);
		builder.append(", email1=");
		builder.append(email1);
		builder.append(", email2=");
		builder.append(email2);
		builder.append("]");
		return builder.toString();
	}

}
