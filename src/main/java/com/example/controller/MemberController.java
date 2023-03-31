package com.example.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;

import io.swagger.annotations.ApiOperation;

//@RestController   //@Controller + @ResponseBody
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService service;
	

	@RequestMapping(value = "/memberForm",method = RequestMethod.GET)
	public String memberForm() {
		System.out.println("/member/memberForm 주소요청 ");
		return "memberForm";
	}
	
	
	
	@RequestMapping(value = "/memberAdd", method = RequestMethod.POST)
	@ApiOperation(value = "회원가입")
	@ResponseBody
	public String register(MemberDTO dto) throws NoSuchAlgorithmException {
		System.out.println("/member/memberAdd : " + dto);
		int n = service.memberAdd(dto);
		System.out.println("insert 갯수 : "+n);
		
		return "회원가입 성공";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST )
	@ApiOperation(value = "아이디 중복체크")
	@ResponseBody
	public String idCheck(@RequestParam("id") String member_code) {
		System.out.println("/idCheck 주소 : " + member_code);
		
		MemberDTO dto = service.mypage(member_code);
		String mesg = "아이디 사용가능";
		if(dto!=null) {
			mesg = "아이디 중복";
		}
		return mesg;
		
	}
	
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("/member/loginForm 주소 요청");
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "로그인")
	@ResponseBody
	public String login(@RequestParam Map<String,String> map, HttpSession session) {
		System.out.println("/login 주소 : "+map);
		MemberDTO dto = service.login(map);
//		System.out.println("db에서 가져온  dto "+dto);
		if(dto!=null) {
			session.setAttribute("login", dto);
			return "redirect:main";
		}else {
			return "loginForm";
		}
		
	}
	
	
	
	
}
