package com.olx;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class OlxLoginAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxLoginAppApplication.class, args);
	}
	
	private ApiInfo getAPiInfo() {
		return new ApiInfo("User Authentication REST API Documentation",
				"User Authentication API's released by Zensar Ltd.","2.5","http://zensar.com/termofservice",
				new Contact("Priyanka","http://priyanka.com","priyanka.bharade@zensar.com"),"GPL","http://gpl.com"
				,new ArrayList<VendorExtension>());
	}
	
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getAPiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.olx"))
				.paths(PathSelectors.any())
				.build();
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
