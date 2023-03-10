package com.ReCykleApp;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ReCykleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReCykleAppApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ReCykleApp")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("ReCykle Application", "Sample api", "1.0", "@Archie",
				new springfox.documentation.service.Contact("Contact me!", "https://www.linkedin.com/in/archeese/",
						"gowork.archis@gmail.com"),
				"API l.0", "https://github.com/starving-array", Collections.emptyList());
	}

}
