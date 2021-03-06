package com.bg.swagger;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket ssaNumberAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
										.select()
											.apis(RequestHandlerSelectors.basePackage("com.bg.controller"))
												.paths(PathSelectors.any())
												.build()
												.apiInfo(apiMetaData());
	}
	
	private ApiInfo apiMetaData() {
		ApiInfo apiInfo=new ApiInfo("Spring Boot Rest API",
															"Spring Version 5.2",
															"http://www.apache.org/licence/LICENCE-2.0",
															"Apache Licence Version 2.0",
															"Bichitra LTD",
															"www.bgsolution.com",
															"Delhi");
		return apiInfo;
	}
}
