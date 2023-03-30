package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String main() {
		System.out.println("/ 주소 요청");
		return "imageForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("로그인폼 주소 요청");
		return "content/loginForm";
		//return "layouts/default_layout";
	}
	
	
}//end class
