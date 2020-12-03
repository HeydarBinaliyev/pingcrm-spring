package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.monolightdemo.inertia.Inertia;
import com.app.monolightdemo.repository.UserRepository;

@Controller
@RequestMapping("/")
public class DashboardController {

	@Autowired
	Inertia inertia;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public Object index(){
		
		Map<String, Object> result = new HashMap<String , Object>();
		
		return inertia.generateResponse("Dashboard/Index", result);
		
	}

}
