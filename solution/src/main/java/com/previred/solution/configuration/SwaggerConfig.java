package com.previred.solution.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        String packageName = "com.previred.solution";
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(packageName)).paths(springfox.documentation.builders.PathSelectors.regex("/.*"))
                .build().apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo("Documentación API: Solución Desafío 1 - Previred", "Documentación para integración.", "1.0",
                null, new Contact("Oscar Quezada", "oscar.quezada.s@outlook.com", ""), null, null);

    }

}
