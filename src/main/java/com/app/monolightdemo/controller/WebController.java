package com.app.monolightdemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.monolightdemo.inertia.Inertia;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	Inertia inertia;
	
	@GetMapping
	public ModelAndView index(){
		
		Map<String, Object> props = new HashMap<>();
		props.put("name", "Heydər Binəliyev");
		
		return (ModelAndView) inertia.generateResponse("home", props);
		
	}
	@GetMapping 
	@RequestMapping("/profil")
	public Object profil(){
		
		
		Map<String, Object> result = new HashMap<>();
	
		result.put("name", "Heydər Binəliyev");
	
		
		return inertia.generateResponse("Profil/Index", result);

	}
}
