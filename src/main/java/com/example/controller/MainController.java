package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	//1 신상품은 상품 목록 객체 번호 order by ITEM_LI_CD desc 로해서 제일 늦은 순서 12개정도가 좋은것 같습니다.
	//10시10.
	@GetMapping("/")
	public String main() {
		System.out.println("main() 메소드 호출");
		return "main";
	}
	
}
