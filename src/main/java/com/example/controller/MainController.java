package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String mainpage() {
		System.out.println("/main페이지");
		return "main";
	}	
	
}//end class