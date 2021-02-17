package com.app.monolightdemo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.monolightdemo.inertia.Inertia;

@Controller
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	Inertia inertia;
	
	@GetMapping
	public Object index() {
		return inertia.generateResponse("Reports/Index", new HashMap<>());
	}
}
