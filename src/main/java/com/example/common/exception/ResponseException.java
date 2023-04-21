package com.example.common.exception;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.dto.ComResponseDTO;
import com.example.common.dto.ComResponseEntity;
import com.example.common.dto.ExceptionResponseDTO;
import com.example.member.exception.NoLoginException;

@ControllerAdvice
@RestController
public class ResponseException {
	
	@ExceptionHandler(Exception.class)
	public ComResponseEntity<ExceptionResponseDTO> handleException(Exception e){
		ExceptionResponseDTO exceptionResponseDto = new ExceptionResponseDTO();
		exceptionResponseDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		exceptionResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionResponseDto.setMessage(e.getMessage());
		return new ComResponseEntity<ExceptionResponseDTO>(new ComResponseDTO<ExceptionResponseDTO>("에러 발생", exceptionResponseDto),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoLoginException.class)
	public ComResponseEntity<ExceptionResponseDTO> noLoginException(Exception e) {
		ExceptionResponseDTO exceptionResponseDto = new ExceptionResponseDTO();
		exceptionResponseDto.setMessage(e.getMessage());
		exceptionResponseDto.setStatus(HttpStatus.NOT_FOUND);
		exceptionResponseDto.setCode(HttpStatus.NOT_FOUND.toString());
		return new ComResponseEntity<>(new ComResponseDTO<>("일치하는 회원이 없습니다.", exceptionResponseDto), HttpStatus.NOT_FOUND);
	}
}
