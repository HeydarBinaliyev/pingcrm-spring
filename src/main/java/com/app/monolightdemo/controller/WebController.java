package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.monolightdemo.inertia.Inertia;

@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	Inertia inertia;
	
	@GetMapping
	public Object index(){
		
		Map<String, Object> props = new HashMap<>();
		props.put("name", "Heydər Binəliyev");
		props.put("type","admin");
		return inertia.generateResponse("home", props);
		
	}
	@GetMapping 
	@RequestMapping("/profil")
	public Object profil(){
		
		
		Map<String, Object> result = new HashMap<>();
	
		result.put("name", "Heydər Binəliyev");
		result.put("type","admin");
		
		return inertia.generateResponse("Profil/Index", result);

	}
}
