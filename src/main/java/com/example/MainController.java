package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	@RequestMapping("/")
	public String vueTest() {
		System.out.println("dd");
		return "index";
	}
	@RequestMapping("/test")
	public String vueTest2() {
		System.out.println("dd");
		return "test";
	}
	
}
