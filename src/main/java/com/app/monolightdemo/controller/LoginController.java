package com.app.monolightdemo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.monolightdemo.inertia.Inertia;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	Inertia inertia;
	
	@GetMapping
	public Object loginPage(HttpServletRequest request) {
		
		return inertia.generateResponse("Auth/Login", new HashMap<>()); 
	}

}
