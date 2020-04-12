package com.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket PDSDocket() {
	return new Docket(DocumentationType.SWAGGER_2).
			select().
			apis(RequestHandlerSelectors.basePackage("com.springtest.controller")).
			build()
			.apiInfo(getApiInfo())
			;
	}

	private ApiInfo getApiInfo() {
		ApiInfo info = new ApiInfo("OMOP transaformation Service API", 
				"API used to transform the data from PDS to OMOP", "Version 1.0", "",
				new Contact("", "", ""), "License", "https://www.apache.org/");
		return info;
	}
}