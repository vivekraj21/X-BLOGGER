package com.springboot.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "X-Blogger App REST APIs",
				description = "REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Vivek Raj",
						email = "vivekrajrollno21@gmail.com"
						),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/vivekraj21/X-Blogger"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "X-Blogger App REST APIs",
				url = "https://github.com/vivekraj21/X-Blogger"
				
				)
		
)
public class SpringbootBlogRestApiApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

}
