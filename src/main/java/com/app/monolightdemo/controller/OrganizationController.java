package com.app.monolightdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.monolightdemo.inertia.Inertia;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	Inertia inertia;
	
	@GetMapping
	public Object index(@RequestParam(name = "search", defaultValue = "") String search,
						@RequestParam(name = "trashed", defaultValue = "") String trashed,
						@RequestParam(name = "page", defaultValue = "0") Integer page) {
		
		
		
		return null;
	}
}
