package com.example.controller;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.dto.LoginDTO;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;

import io.swagger.annotations.ApiOperation;

//@RestController   //@Controller + @ResponseBody
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService service;
	
	private static final Logger logger = LogManager.getLogger(MemberController.class);
	

	@RequestMapping(value = "/memberForm",method = RequestMethod.GET)
	public String memberForm() {
		System.out.println("/member/memberForm 주소요청 ");
		return "memberForm";
	}
	
	

	@PostMapping("/memberAdd")
	@ApiOperation(value = "회원가입")
	@ResponseBody
	public ResponseEntity<Object> memberAdd(MemberDTO memberDTO) throws NoSuchAlgorithmException {
		System.out.println("/member/memberAdd : " + memberDTO);
		int n = service.memberAdd(memberDTO);
		System.out.println("insert 갯수 : "+n);
		logger.debug("insert 갯수 : "+n);
		
		return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
	}
	
	
//	@RequestMapping("/idCheck")
//	@ResponseBody
//	public String idCheck() {
//		return "";
//	}//id가 없을 시 404 에러가 나서.....................ㅠㅠ
	

	@PostMapping("/idCheck/{mbId}")
	@ApiOperation(value = "아이디 중복체크")
	public ResponseEntity<String> idCheck(@PathVariable("mbId") String mbId) {
		System.out.println("/idCheck 주소 : " + mbId);
		
		MemberDTO memberDTO = service.mypage(mbId);
		System.out.println("/idCheck " + memberDTO);
		String mesg = "아이디 사용가능";
//		HttpHeaders header = new HttpHeaders();
//		header.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
		if(memberDTO!=null) {
			mesg ="아이디 중복";
			return new ResponseEntity<String>(mesg, HttpStatus.OK);  
			
		}else {
			return new ResponseEntity<String>(mesg,HttpStatus.OK);
		}
		
		
	}
	
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("/member/loginForm 주소 요청");
		return "loginForm";
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping("/login")
	@ApiOperation(value = "로그인")
	public ResponseEntity<Object> login(@RequestParam String mbId,@RequestParam String pw, HttpSession session) {
		System.out.println("/login 주소 : "+mbId+"\t"+pw);
		
	
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setMbId(mbId);
		loginDTO.setPw(pw);
		MemberDTO memberDTO = service.login(loginDTO); 
		System.out.println("db에서 가져온  memberDTO "+memberDTO);
		
		
//		return "hello"; 

		if(memberDTO!=null) {
			session.setAttribute("memberInfo", memberDTO);
			return new ResponseEntity<>("로그인 성공",HttpStatus.OK);
//			return ResponseEntity.ok().build();  //상태코드만 반환해 줄 때 
					
					
		}else {
			return new ResponseEntity<>("존재하지 않는 회원",HttpStatus.NOT_FOUND);
//			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	
}
