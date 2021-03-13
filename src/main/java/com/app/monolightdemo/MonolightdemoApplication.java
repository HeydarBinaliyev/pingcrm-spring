package com.app.monolightdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MonolightdemoApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MonolightdemoApplication.class, args);
	}

}
