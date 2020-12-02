package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public Object index(@RequestParam(name = "name", defaultValue = "") String name,
						@RequestParam(name = "offset", defaultValue = "") Integer offset){
		
		Integer __offset = offset==null?0:offset;
		
		List<UserDTO> users = userRepository.getAllUsers(5, __offset, name);
		Integer totalCount = userRepository.getAllUsersCount(name);
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
