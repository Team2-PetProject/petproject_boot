package com.example.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.admin.exception.AdminException;
import com.example.common.SessionAttributeManager;

public class AdminCheckInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LogManager.getLogger(AdminCheckInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Pre Interceptor");
		if("admin".equals(SessionAttributeManager.getMemberId())) {//로그인 안된 경우
			throw new AdminException("관리자 권한이 필요합니다.");
		}else { //로그인 시
			return true;
		}
		
		
		// TODO Auto-generated method stub
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	

	
	
	
	
}
