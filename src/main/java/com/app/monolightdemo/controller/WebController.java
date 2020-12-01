package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.inertia.Inertia;
import com.app.monolightdemo.repository.UserRepository;

@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	Inertia inertia;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public Object index(){
		
		List<UserDTO> users = userRepository.getAllUsers(5,0,"");
		Integer totalCount = userRepository.getAllUsersCount("");
		Map<String, Object> result = new HashMap<String , Object>();
		
		result.put("users", users);
		result.put("count",	totalCount);
		
		return inertia.generateResponse("home", result);
		
	}
	@GetMapping 
	@RequestMapping("/profil")
	public Object profil(){
		
		
		
	
		List<UserDTO> users = userRepository.getAllUsers(5,0,"");
		Integer totalCount = userRepository.getAllUsersCount("");
		Map<String, Object> result = new HashMap<String , Object>();
		
		result.put("users", users);
		result.put("count",	totalCount);
		
		return inertia.generateResponse("Profil/Index", result);

	}
}
