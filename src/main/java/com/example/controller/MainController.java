package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
//	@RequestMapping(value = "/")
	public String main() {
		System.out.println("/ 주소 요청");
		return "imageForm";
	}
	
}
