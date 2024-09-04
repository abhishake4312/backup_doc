package com.learn.springsecuritysection10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug=true)
@EnableMethodSecurity(prePostEnabled=true, securedEnabled=true, jsr250Enabled=true)
public class BankApplicationBackend {

	public static void main(String[] args) {
		SpringApplication.run(BankApplicationBackend.class, args);
	}

}
