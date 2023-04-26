package com.example.member.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.SessionAttributeManager;
import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.member.dto.EmailAuthRequestDTO;
import com.example.member.dto.LoginDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.service.EmailService;
import com.example.member.service.MemberService;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/emailConfirm")
public class EmailController {

	@Autowired
	EmailService emailService;
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LogManager.getLogger(EmailController.class);

	@PostMapping("/idSearch")
	@ApiOperation(value = "아이디찾기")
	public ComResponseEntity<Void> idEmailConfirm(@RequestBody EmailAuthRequestDTO emailDTO,HttpSession session)throws MessagingException, UnsupportedEncodingException {
		
		MemberDTO mDto = new MemberDTO();
		mDto.setEmail1(emailDTO.getEmail1());
		mDto.setEmail2(emailDTO.getEmail2());
		
		String mbId = memberService.idSearch(mDto);
		
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		
		
		if(mbId != null) {
			String authCode = emailService.sendEmail(mDto.getEmail1()+"@"+mDto.getEmail2());
			session.setAttribute("mbId", mbId);
			logger.info("아이디찾기mbId>>>>>>>>"+session.getAttribute("mbId"));
			session.setAttribute("authCode", authCode);
			logger.info("메일전송 후 authCode>>>>>>"+ session.getAttribute("authCode"));
			comResponseDTO.setMessage("아이디 찾기 인증 번호 메일 전송 완료");
			return new ComResponseEntity<Void>(comResponseDTO);
			
		}else {
			comResponseDTO.setMessage("존재 하지 않는 회원입니다.");
			return new ComResponseEntity<Void>(comResponseDTO);
		}
		
	}
	
	@PostMapping("/idSearch/authConfirm/{receiveAuthCd}")
	@ApiOperation(value = "아이디 찾기 인증번호 확인")
	public ComResponseEntity<Object> idAuthConfirm(@PathVariable String receiveAuthCd){
		logger.info("입력된 인증번호 receiveAuthCd>>>>>>"+ receiveAuthCd);
		ComResponseDTO<Object> comResponseDTO = new ComResponseDTO<Object>();
		String authCode = (String) SessionAttributeManager.getSession().getAttribute("authCode");
		String mbId = (String) SessionAttributeManager.getSession().getAttribute("mbId");
		if(receiveAuthCd.equals(authCode)) {
			SessionAttributeManager.getSession().removeAttribute("mbId");
			SessionAttributeManager.getSession().removeAttribute("authCode");
			logger.info("아이디 찾기 session remove 후>>>>>>"+
				(String) SessionAttributeManager.getSession().getAttribute("authCode")
				+"\t"+(String) SessionAttributeManager.getSession().getAttribute("mbId"));
			comResponseDTO.setMessage("인증 완료");
			comResponseDTO.setBody(mbId);
			return new ComResponseEntity<Object>(comResponseDTO);
			
		}else {
			comResponseDTO.setMessage("유효하지 않은 인증번호 입니다.");
			return new ComResponseEntity<Object>(comResponseDTO);
		}
		
	}
	
	
	@PostMapping("/pwSearch")
	@ApiOperation("비밀번호 찾기")
	public ComResponseEntity<Void> pwEmailConfirm(@RequestBody EmailAuthRequestDTO emailDTO,HttpSession session) throws MessagingException, UnsupportedEncodingException {
		
		MemberDTO mDto = new MemberDTO();
		mDto.setEmail1(emailDTO.getEmail1());
		mDto.setEmail2(emailDTO.getEmail2());
		
		String mbId = memberService.idSearch(mDto);
		
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		
		if(emailDTO.getMbId().equals(mbId)) {
			String authCode = emailService.sendEmail(mDto.getEmail1()+"@"+mDto.getEmail2());
			session.setAttribute("mbId", mbId);
			session.setAttribute("authCode", authCode);
			logger.info("비밀번호 찾기 mbId>>>>>>>>"+session.getAttribute("mbId"));
			logger.info("메일전송 후 authCode>>>>>>"+ session.getAttribute("authCode"));
			comResponseDTO.setMessage("비밀번호 찾기 인증 번호 메일 전송 완료");
			return new ComResponseEntity<Void>(comResponseDTO);
			
		}else {
			comResponseDTO.setMessage("존재 하지 않는 회원입니다.");
			return new ComResponseEntity<Void>(comResponseDTO);
		}
	}
	
	
	@PostMapping("/pwSearch/authConfirm/{receiveAuthCd}")
	@ApiOperation(value = "비밀번호 찾기 인증번호 확인")
	public ComResponseEntity<Void> pwAuthConfirm(@PathVariable String receiveAuthCd){
		logger.info("입력된 비밀번호 인증번호 receiveAuthCd>>>>>>"+ receiveAuthCd);
		String authCode = (String) SessionAttributeManager.getSession().getAttribute("authCode");
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		
		if(receiveAuthCd.equals(authCode)) {
			comResponseDTO.setMessage("인증 완료");
			return new ComResponseEntity<Void>(comResponseDTO);
			
		}else {
			comResponseDTO.setMessage("유효하지 않은 인증번호 입니다.");
			return new ComResponseEntity<Void>(comResponseDTO);
		}
		
	}
	
	@PutMapping("/pwSearch/authConfirm/pwUpdate")
	@ApiOperation(value = "새 비밀번호 변경")
	public ComResponseEntity<Void> pwAuthConfirm(@RequestBody EmailAuthRequestDTO emailDTO){
		String mbId = (String) SessionAttributeManager.getSession().getAttribute("mbId");
		String authCode = (String) SessionAttributeManager.getSession().getAttribute("authCode"); //테스트되면 지우기
		ComResponseDTO<Void> comResponseDTO = new ComResponseDTO<Void>();
		
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setMbId(emailDTO.getMbId());
		loginDTO.setPw(emailDTO.getPw());
		
		if(emailDTO.getMbId().equals(mbId)) {
			Integer n = memberService.pwUpdate(loginDTO);
			logger.info("비밀번호 업데이트 개수>>>>>>"+n);
			
			if(n==1) {
				SessionAttributeManager.getSession().removeAttribute("mbId");
				SessionAttributeManager.getSession().removeAttribute("authCode");
				logger.info("아이디 찾기 session invalidate 후>>>>>>"+
						(String) SessionAttributeManager.getSession().getAttribute("authCode")
						+"\t"+(String) SessionAttributeManager.getSession().getAttribute("mbId"));
				comResponseDTO.setMessage("비밀번호 변경 완료");
				return new ComResponseEntity<Void>(comResponseDTO);
			}
			
			comResponseDTO.setMessage("비밀번호 변경 실패");
			return new ComResponseEntity<Void>(comResponseDTO);
		}else {
			comResponseDTO.setMessage("비밀번호 변경 실패");
			return new ComResponseEntity<Void>(comResponseDTO);
		}
		
	}//end pwUpdate
	
	
	
	
	
}//end class