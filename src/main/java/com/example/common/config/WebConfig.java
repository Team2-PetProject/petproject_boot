package com.example.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.common.Interceptor.AdminCheckInterceptor;
import com.example.common.Interceptor.LoginCheckInterceptor;
import com.example.common.dto.AdminDTO;
import com.example.common.dto.LoginInterceptorDTO;
import com.example.common.dto.PortInterceptorDTO;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LoginInterceptorDTO loginList = getLogin();
		AdminDTO adminList = getAdmin();
		registry.addInterceptor(new LoginCheckInterceptor())
		.addPathPatterns(loginList.getList());
		registry.addInterceptor(new AdminCheckInterceptor())
		.addPathPatterns(adminList.getList());
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		PortInterceptorDTO portList = getPort();
		   registry.addMapping("/**")
		   .allowedOrigins(portList.getList())
           .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
           .allowedHeaders("*")
           .allowCredentials(true)
           .maxAge(3600);
	}

	@Bean
	@ConfigurationProperties(prefix="login")
	public LoginInterceptorDTO getLogin() {
		return new LoginInterceptorDTO();
	}

	@Bean
	@ConfigurationProperties(prefix="admin")
	public AdminDTO getAdmin() {
		return new AdminDTO();
	}

	@Bean
	@ConfigurationProperties(prefix="port")
	public PortInterceptorDTO getPort() {
		return new PortInterceptorDTO();
	}
}