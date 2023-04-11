package com.example.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.common.SessionAttributeManager;
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
	public ResponseEntity<Object> memberAdd(MemberDTO memberDTO){
		System.out.println("/member/memberAdd : " + memberDTO);
		Integer n = service.memberAdd(memberDTO);
		logger.info("insert 갯수 : "+n);
		
		return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
	}
	
	

	

	@PostMapping("/idCheck/{mbId}")
	@ApiOperation(value = "아이디 중복체크")
	public ResponseEntity<String> idCheck(@PathVariable("mbId") String mbId) {
		logger.info("/idCheck 주소 : " + mbId);
		
		Integer count = service.idCheck(mbId);
		logger.info("/idCheck id count " + count);
		String mesg = "아이디 사용가능";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
		if(count == 1) {
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
	
	
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인")
	public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO, HttpSession session){

//		logger.info("/login ======"+ loginDTO);
		MemberDTO memberDTO = service.login(loginDTO); 
		logger.info("db에서 가져온  memberDTO "+memberDTO);

		if(memberDTO!=null) {
			session.setAttribute("memberInfo", memberDTO);
			return new ResponseEntity<>("로그인 성공",HttpStatus.OK);
//			return ResponseEntity.ok().build();  //상태코드만 반환해 줄 때 
					
		}else {
			return new ResponseEntity<>("존재하지 않는 회원",HttpStatus.NOT_FOUND);
//			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@DeleteMapping("check/logout")
	@ApiOperation(value = "로그아웃")
	public ResponseEntity<Object> logout(HttpSession session){
		
		SessionAttributeManager.getSession().invalidate();
		return new ResponseEntity<>("로그아웃 성공", HttpStatus.OK);
	}
	
	
	@GetMapping("check/mypage/{mbId}")
	@ApiOperation(value = "회원정보보기")
	public ResponseEntity<MemberDTO> mypage(@PathVariable String mbId){
		
		MemberDTO memberDTO = service.mypage(mbId);
		return new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
	}
	
	
	
	
	@PutMapping("check/update")
	@ApiOperation(value = "회원정보수정")
	public ResponseEntity<Object> update(@RequestBody MemberDTO memberDTO){
		
		Integer n = service.memberUpdate(memberDTO);
		
		logger.info("업데이트갯수>>>>>>"+n);
		
		return new ResponseEntity<>("회원정보수정 성공", HttpStatus.OK);
				
	}
	
	
	
	
	
	
	
}