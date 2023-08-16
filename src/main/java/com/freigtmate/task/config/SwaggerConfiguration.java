package com.freigtmate.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 *  @author hitesh.bidve
 *  @implnote Implemtation swagger documention helps generate documents of REST APIs for 
 *  RESTful web services via a web browser.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration 
{

	/*
	 * This method contains all the customizable properties you set and is used by Swagger 
	 * to generate the documentation.
	 */
	@Bean
	public Docket api() 
	{
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.freigtmate.task.controller"))
			.paths(PathSelectors.any())
			.build().apiInfo(apiInfo());
	}

	
	/*
	 * ApiInfo is the object that allows you as a developer to add Contact information, 
	 * descriptions of the API, title, terms of use, and other information.
	 */
	private ApiInfo apiInfo() 
	{
		return new ApiInfoBuilder()
			.title("Welcome to Freightmate Application")
			.description("Suburb Application with Documentation")
			.version("1.0")
			.contact(new Contact("Hitesh Bidve", "www.rishabhsoft.com", "hitesh.bidve@rishabhsoft.com"))
			.build();
	}
}
