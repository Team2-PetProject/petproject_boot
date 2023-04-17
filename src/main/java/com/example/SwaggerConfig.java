package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig{	
	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
				.version("v1.0.0")
				.title("API 타이틀")
				.description("API Description");
		return new OpenAPI().info(info);
	}
}
