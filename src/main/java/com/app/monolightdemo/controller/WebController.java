package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/")
public class WebController {

	@GetMapping
	public ModelAndView index(ModelMap model) throws JsonProcessingException {
		
		ModelAndView page = new ModelAndView("index");
		Map<String, Object> props = new HashMap<>();
		props.put("component", "home");
		props.put("url", "/");
		Map<String, Object> component_props = new HashMap<>();
		component_props.put("name", "Heydar Binaliyev");
		props.put("props", component_props);
		
		model.addAttribute("page", new ObjectMapper().writeValueAsString(props));
		page.addObject(model);
		return page;
	}
}
