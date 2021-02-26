package com.app.monolightdemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.monolightdemo.dto.UserCreateDTO;
import com.app.monolightdemo.inertia.Inertia;
import com.app.monolightdemo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	Inertia inertia;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public Object index(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "trashed", defaultValue = "") String trashed,
			@RequestParam(name = "role", defaultValue = "") String role, HttpServletRequest request) {
		
		Map<String, String> filters = new HashMap<>();
		filters.put("search", search);
		filters.put("trashed", trashed);
		filters.put("role", role);
		
		
		Map<String, Object> result = new HashMap<>();
		result.put("users", userService.getUsers(search, trashed, role));
		result.put("filters", filters);
		
		return inertia.generateResponse("Users/Index", result);
		
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public Object create() {
		return inertia.generateResponse("Users/Create", new HashMap<>());
	}
	
	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(@ModelAttribute UserCreateDTO userDTO, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Map<String, Object> flash = new HashMap<>();
		
		try {
			
			userService.storeUser(userDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			Map<String, Object> errors = new HashMap<>();
			errors.put("name", "Organization could not created.");
			request.getSession().setAttribute("errors", errors);
			response.sendRedirect("/organizations/create");
			return;
		}
		
		flash.put("success", "User created.");
		
		request.getSession().setAttribute("flash", flash);
		
		response.sendRedirect("/users");
		
	}
	
	@RequestMapping(path = "/{id}/edit" ,method = RequestMethod.GET )
	public Object edit(@PathVariable(name = "id") Integer id) {
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("user", userService.getUserById(id));
		
		return inertia.generateResponse("Users/Edit", result);
	}
	
	@PutMapping(path = "/{id}")
	public Object update(@PathVariable(name = "id",required = true) Integer id, @ModelAttribute UserCreateDTO userDTO) {
		
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> flash = new HashMap<>();
		
		userService.updateUser(id, userDTO);
		
		flash.put("success", "User updated.");
		result.put("flash", flash);
		return inertia.generateResponse(null, result);
	}
	
	@RequestMapping(path = "/{id}",  method = RequestMethod.DELETE)
	public Object delete(@PathVariable(name = "id",  required = true) Integer id) {

		Map<String, Object> result = new HashMap<>();
		Map<String, Object> flash = new HashMap<>();
		
		userService.deleteUser(id);
		
		flash.put("success", "User deleted.");
		result.put("flash", flash);
		
		return inertia.generateResponse(null, result);
	}
	
	@RequestMapping(path = "/restore/{id}",  method = RequestMethod.PUT)
	public Object restore(@PathVariable(name = "id",  required = true) Integer id) {

		Map<String, Object> result = new HashMap<>();
		Map<String, Object> flash = new HashMap<>();
		
		userService.restoreUser(id);
		
		flash.put("success", "User restored.");
		result.put("flash", flash);
		
		return inertia.generateResponse(null, result);
	}
}
