package com.tneciv.zebra.config;

import org.springframework.beans.factory.annotation.Value;
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tneciv.apprelease"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Tneciv", "https://github.com/Tneciv", "tnecivl@gmail.com");
        return new ApiInfoBuilder()
                .title(String.format("APP 发布平台（ %s ）", this.springApplicationName))
                .description("Powered by Tneciv at https://github.com/Tneciv")
                .termsOfServiceUrl("https://github.com/Tneciv")
                .contact(contact)
                .version("1.0")
                .build();
    }

}