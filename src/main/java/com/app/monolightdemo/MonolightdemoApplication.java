package com.app.monolightdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.app.monolightdemo.dto.UserDTO;



@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MonolightdemoApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MonolightdemoApplication.class, args);
	}

	  
    @Bean(name = "sessionUsers")
    public List<UserDTO> sessionUsers(){
    	return new ArrayList<UserDTO>();
    }
    

}
