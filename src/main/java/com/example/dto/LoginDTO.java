package com.example.dto;

public class LoginDTO {
String MB_ID;
String PW;
public LoginDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public String getMB_ID() {
	return MB_ID;
}
public void setMB_ID(String mB_ID) {
	MB_ID = mB_ID;
}
public String getPW() {
	return PW;
}
public void setPW(String pW) {
	PW = pW;
}
@Override
public String toString() {
	return "LoginDTO [MB_ID=" + MB_ID + ", PW=" + PW + "]";
}



}
