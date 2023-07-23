package com.bank.banksystem;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// customising the information for the swagger API documentation
@OpenAPIDefinition(
		info = @Info(
				title = "Zilla Bank",
				description = "Backend Rest APIs for Zilla Bank",
				version = "v1.0",
				contact = @Contact(
						name = "Adejumo Idris",
						email = "idrisadejumo@gmail.com",
						url = "https://github.com/adejumoisris"
				),
				license = @License(
						name = "Zilla Bank",
						url = "https://github.com/adejumoisris"

				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Zilla Bank App Documentation",
				url= "https://github.com/adejumoisris"
		)

)
public class BankSystemApplication {
	// customizing the UI documentation

	public static void main(String[] args) {
		SpringApplication.run(BankSystemApplication.class, args);
		System.out.println("hello");
	}

}
