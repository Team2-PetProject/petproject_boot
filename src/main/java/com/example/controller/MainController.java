package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String main() {
		System.out.println("/ 주소 요청");
		return "imageForm";
	}
	
	@GetMapping("/main")
	public String mainpage() {
		System.out.println("/main페이지");
		return "content/main";
	}
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("로그인폼 주소 요청");
		return "content/loginForm";
		//return "layouts/default_layout";
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login() {
		System.out.println("로그인");
		return "login";
	}
	
}//end class
