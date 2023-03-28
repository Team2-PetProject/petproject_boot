package com.example.dto;

public class MemberDTO {
	private String Member_code;
	private String Member_passwd;
	private String Member_name;
	private String Member_post;
	private String Member_addr1;
	private String Member_addr2;
	private String Member_phone1;
	private String Member_phone2;
	private String Member_phone3;
	private String Member_email1;
	private String Member_email2;
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String member_code, String member_passwd, String member_name, String member_post,
			String member_addr1, String member_addr2, String member_phone1, String member_phone2, String member_phone3,
			String member_email1, String member_email2) {
		super();
		Member_code = member_code;
		Member_passwd = member_passwd;
		Member_name = member_name;
		Member_post = member_post;
		Member_addr1 = member_addr1;
		Member_addr2 = member_addr2;
		Member_phone1 = member_phone1;
		Member_phone2 = member_phone2;
		Member_phone3 = member_phone3;
		Member_email1 = member_email1;
		Member_email2 = member_email2;
	}
	public String getMember_code() {
		return Member_code;
	}
	public void setMember_code(String member_code) {
		Member_code = member_code;
	}
	public String getMember_passwd() {
		return Member_passwd;
	}
	public void setMember_passwd(String member_passwd) {
		Member_passwd = member_passwd;
	}
	public String getMember_name() {
		return Member_name;
	}
	public void setMember_name(String member_name) {
		Member_name = member_name;
	}
	public String getMember_post() {
		return Member_post;
	}
	public void setMember_post(String member_post) {
		Member_post = member_post;
	}
	public String getMember_addr1() {
		return Member_addr1;
	}
	public void setMember_addr1(String member_addr1) {
		Member_addr1 = member_addr1;
	}
	public String getMember_addr2() {
		return Member_addr2;
	}
	public void setMember_addr2(String member_addr2) {
		Member_addr2 = member_addr2;
	}
	public String getMember_phone1() {
		return Member_phone1;
	}
	public void setMember_phone1(String member_phone1) {
		Member_phone1 = member_phone1;
	}
	public String getMember_phone2() {
		return Member_phone2;
	}
	public void setMember_phone2(String member_phone2) {
		Member_phone2 = member_phone2;
	}
	public String getMember_phone3() {
		return Member_phone3;
	}
	public void setMember_phone3(String member_phone3) {
		Member_phone3 = member_phone3;
	}
	public String getMember_email1() {
		return Member_email1;
	}
	public void setMember_email1(String member_email1) {
		Member_email1 = member_email1;
	}
	public String getMember_email2() {
		return Member_email2;
	}
	public void setMember_email2(String member_email2) {
		Member_email2 = member_email2;
	}
	@Override
	public String toString() {
		return "MemberDTO [Member_code=" + Member_code + ", Member_passwd=" + Member_passwd + ", Member_name="
				+ Member_name + ", Member_post=" + Member_post + ", Member_addr1=" + Member_addr1 + ", Member_addr2="
				+ Member_addr2 + ", Member_phone1=" + Member_phone1 + ", Member_phone2=" + Member_phone2
				+ ", Member_phone3=" + Member_phone3 + ", Member_email1=" + Member_email1 + ", Member_email2="
				+ Member_email2 + "]";
	}
	
}
	