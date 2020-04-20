package com.bridgelabz.UserManagement;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Tejashree Surve
 * @Purpose : Configuration for Swagger.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.UserManagement")).build();
	}
}