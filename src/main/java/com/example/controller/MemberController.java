package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController   //@Controller + @ResponseBody
@Controller
public class MemberController {
	
	@RequestMapping("/")
	public String main() {
		System.out.println("/ 주소 요청");
		return "main";
	}
	
	
	@RequestMapping("/login")
	public String login(String member_code, String member_passwd) {
		System.out.println("/login 주소 요청  : "+ member_code+"\t"+member_passwd);
		return "main";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("/loginForm 주소 요청");
		return "loginForm";
	}
	
	
}
