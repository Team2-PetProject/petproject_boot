package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.LoginDTO;

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
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login(@RequestBody LoginDTO dto) {
		System.out.println("로그인됨");
		System.out.println(dto);
		return "login";
	}
	
	@GetMapping("/SignUp")
	public String signUp() {
		System.out.println("회원가입");
		return "content/SignUp";
	}
	
}//end class
