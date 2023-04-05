package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	//1 신상품은 상품 목록 객체 번호 order by ITEM_LI_CD desc 로해서 제일 늦은 순서 12개정도가 좋은것 같습니다.
	//10시10.
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
	
	@GetMapping("/mainTest")
	public String mainTest() {
		System.out.println("/mainTest페이지");
		return "/main";
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
