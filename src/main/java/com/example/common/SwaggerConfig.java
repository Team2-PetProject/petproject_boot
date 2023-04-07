package com.example.common;

import java.util.HashSet;
import java.util.Set;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2);
//    }
//    
//    
//    
//}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo commonInfo() {
        return new ApiInfoBuilder()
                .title("PetProject")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket imageApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.consumes(getConsumeContentTypes())
        		.produces(getProduceContentTypes())
                .groupName("image")
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/app/api/image/**"))
                .build()
                .apiInfo(commonInfo());
    }
    @Bean
    public Docket mainApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.consumes(getConsumeContentTypes())
        		.produces(getProduceContentTypes())
                .groupName("main")
                .useDefaultResponseMessages(false)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.ant("/app/"))
                .build()
                .apiInfo(commonInfo());
    }
    private Set<String> getConsumeContentTypes(){
    	Set<String> consumes = new HashSet<String>();
    	consumes.add("application/json;charset=UTF-8");
    	consumes.add("application/x-www-form-urlencoded");
    	return consumes;
    }
    
    private Set<String> getProduceContentTypes(){
    	Set<String> produces = new HashSet<String>();
    	produces.add("application/json;charset=UTF-8");
    	return produces;
    }
}