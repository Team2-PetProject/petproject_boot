package com.example.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;

//@RestController   //@Controller + @ResponseBody
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService service;
	
//	@RequestMapping("/member")
//	public String main() {
//		System.out.println("/member 주소 요청");
//		return "main";
//	}
//	
//	
//	@RequestMapping("/login")
//	public String login(String member_code, String member_passwd) {
//		System.out.println("/login 주소 요청  : "+ member_code+"\t"+member_passwd);
//		return "main";
//	}
//	
//	@RequestMapping("/loginForm")
//	public String loginForm() {
//		System.out.println("/loginForm 주소 요청");
//		return "loginForm";
//	}
	
	@RequestMapping(value = "/memberForm",method = RequestMethod.GET)
	public String memberForm() {
		System.out.println("/member/memberForm 주소요청 ");
		return "memberForm";
	}
	
	@RequestMapping(value = "/memberAdd", method = RequestMethod.POST)
	@ResponseBody
	public String register(MemberDTO dto) throws NoSuchAlgorithmException {
		System.out.println("/member/memberAdd : " + dto);
		int n = service.memberAdd(dto);
		System.out.println("insert 갯수 : "+n);
		
		return "main 회원가입 성공";
	}
	
	
}
