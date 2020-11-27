package com.app.monolightdemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

@Controller
@RequestMapping("/")
public class WebController {

	@GetMapping
	public ModelAndView index(ModelMap model) throws JsonProcessingException {
		
		ModelAndView page = new ModelAndView("index");
		Map<String, Object> props = new HashMap<>();
		props.put("component", "home");
		props.put("url", "/");
		props.put("version","");
		Map<String, Object> component_props = new HashMap<>();
		component_props.put("name", "Heydar Binaliyev");
		props.put("props", component_props);
		
		model.addAttribute("page", new ObjectMapper().writeValueAsString(props));
		page.addObject(model);
		return page;
	}
	@GetMapping 
	@RequestMapping("/profil")
	public Object profil(HttpServletRequest request ,HttpServletResponse response ,ModelMap model) throws IOException {
		
		
		Map<String, Object> props = new HashMap<>();
		props.put("component", "Profil/Index");
		props.put("url", "/profil");
		props.put("version","");
		Map<String, Object> component_props = new HashMap<>();
		component_props.put("name", "Heydar Binaliyev");
		props.put("props", component_props);
		String data = new ObjectMapper().writeValueAsString(props);
		if(request.getHeader("X-Inertia") == null) {
			ModelAndView page = new ModelAndView("index");
			response.setContentType("application/json");
			model.addAttribute("page", data);
			page.addObject(model);
			
			return page;
		}
		
		response.addHeader("X-Inertia", "true");
		response.addHeader("Vary", "Accept");
		return new ResponseEntity<String>(data, HttpStatus.OK);

	}
}
