package com.online.movieticketbookingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiDetails());


       /*  TO add doc to specific API URLS
       .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.bank.application"))
                .build()
                .apiInfo(apiDetails());*/
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Online Movie Ticket Booking APPLICATION",
                "All Movie Ticket Booking application APIs.",
                "V1.0",
                "Terms of service",
                new Contact("Pranith", "www.google.com", "ramannagaripranith96@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
