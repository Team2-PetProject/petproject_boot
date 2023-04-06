package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String mainpage() {
		System.out.println("/main페이지");
		return "content/main";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("로그인폼 주소 요청");
		return "content/loginForm";
	}
	
	
	@GetMapping("/SignUp")
	public String signUp() {
		System.out.println("회원가입");
		return "content/SignUp";
	}
	@GetMapping("/register")
	public String register() {
		return "imageForm";
	}
	
	
}//end class
