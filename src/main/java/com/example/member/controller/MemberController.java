
package com.example.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.member.dto.LoginDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;

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
	public ComResponseEntity<Void> memberAdd(@RequestBody MemberDTO memberDTO){
		System.out.println("/member/memberAdd : " + memberDTO);
		Integer n = service.memberAdd(memberDTO);
		logger.info("insert 갯수 : "+n);
		
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		comResponseDTO.setMessage("회원가입 성공");
		return new ComResponseEntity<Void>(comResponseDTO);
	}
	
	

	

	@PostMapping("/idCheck/{mbId}")
	@ApiOperation(value = "아이디 중복체크")
	public ComResponseEntity<Void> idCheck(@PathVariable("mbId") String mbId) {
		logger.info("/idCheck 주소 : " + mbId);
		
		Integer count = service.idCheck(mbId);
		logger.info("/idCheck id count " + count);
		String mesg = "아이디 사용가능";
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		if(count == 1) {
			mesg ="아이디 중복";
			comResponseDTO.setMessage(mesg);
			return new ComResponseEntity<Void>(comResponseDTO);
			
		}else {
			comResponseDTO.setMessage(mesg);
			return new ComResponseEntity<Void>(comResponseDTO);
		}
		
		
	}
	
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("/member/loginForm 주소 요청");
		return "loginForm";
	}
	
	
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인")
	public ComResponseEntity<Void> login(@RequestBody LoginDTO loginDTO, HttpSession session){

//		logger.info("/login ======"+ loginDTO);
		MemberDTO memberDTO = service.login(loginDTO); 
		logger.info("db에서 가져온  memberDTO "+memberDTO);
		

		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		if(memberDTO!=null) {
			session.setAttribute("memberInfo", memberDTO);
			comResponseDTO.setMessage("로그인 성공");
			return new ComResponseEntity<Void>(comResponseDTO);
					
		}else {
			comResponseDTO.setMessage("존재하지 않는 회원");
			return new ComResponseEntity<Void>(comResponseDTO, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@DeleteMapping("check/logout")
	@ApiOperation(value = "로그아웃")
	public ComResponseEntity<Void> logout(HttpSession session){
		
		SessionAttributeManager.getSession().invalidate();
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		comResponseDTO.setMessage("로그아웃 성공");
		return new ComResponseEntity<Void>(comResponseDTO);
	}
	
	
	@GetMapping("check/mypage/{mbId}")
	@ApiOperation(value = "회원정보보기")
	public ComResponseEntity<MemberDTO> mypage(@PathVariable String mbId){
		
		MemberDTO memberDTO = service.mypage(mbId);
		ComResponseDTO<MemberDTO> comResponseDTO = new ComResponseDTO<MemberDTO>();
		comResponseDTO.setMessage("회원정보보기");
		comResponseDTO.setBody(memberDTO);
		return new ComResponseEntity<MemberDTO>(comResponseDTO);
	}
	
	
	
	
	@PutMapping("check/update")
	@ApiOperation(value = "회원정보수정")
	public ComResponseEntity<Void> update(@RequestBody MemberDTO memberDTO){
		
		Integer n = service.memberUpdate(memberDTO);
		
		logger.info("업데이트갯수>>>>>>"+n);
		
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		comResponseDTO.setMessage("회원정보수정 성공");
		return new ComResponseEntity<Void>(comResponseDTO);
				
	}
	
	
	
	
	
	
	
}