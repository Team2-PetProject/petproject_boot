package com.example.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.common.Interceptor.LoginCheckInterceptor;
import com.example.common.dto.LoginList;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LoginList loginList = getLogin();
		registry.addInterceptor(new LoginCheckInterceptor())
		.addPathPatterns(loginList.getList());
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		   registry.addMapping("/**")
		   .allowedOrigins("http://localhost:8081","http://localhost:8080")
           .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
           .allowedHeaders("*")
           .allowCredentials(true)
           .maxAge(3600);
	}
	
	@Bean
	@ConfigurationProperties(prefix="login")
	public LoginList getLogin() {
		return new LoginList();
	}


}