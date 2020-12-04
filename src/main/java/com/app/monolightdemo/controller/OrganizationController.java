package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.monolightdemo.dto.LinkDTO;
import com.app.monolightdemo.entity.Organization;
import com.app.monolightdemo.inertia.Inertia;
import com.app.monolightdemo.service.OrganizationService;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	Inertia inertia;
	
	@Autowired
	OrganizationService organizationService;
	
	@GetMapping
	public Object index(@RequestParam(name = "search", defaultValue = "") String search,
						@RequestParam(name = "trashed", defaultValue = "") String trashed,
						@RequestParam(name = "page", defaultValue = "1") Integer page,
						HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		
		List<Organization> organizations = (List<Organization>) organizationService.getOrganizations(search, trashed, page);
		List<LinkDTO> links = (List<LinkDTO>) organizationService.getLinks("http://localhost:8081/organizations", search, trashed, page);
		Map<String, Object> data = new HashMap<>();
		data.put("data", organizations);
		data.put("links", links);
		result.put("organizations", data);
		Map<String, String> filters = new HashMap<>();
		filters.put("search", search);
		filters.put("trashed", trashed);
		result.put("filters", filters);
		
		
		return inertia.generateResponse("Organizations/Index", result);
	}
}
