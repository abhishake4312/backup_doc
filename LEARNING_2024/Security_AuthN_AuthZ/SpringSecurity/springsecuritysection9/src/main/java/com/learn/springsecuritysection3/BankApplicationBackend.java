package com.learn.springsecuritysection3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug=true)
public class BankApplicationBackend {

	public static void main(String[] args) {
		SpringApplication.run(BankApplicationBackend.class, args);
	}

}
