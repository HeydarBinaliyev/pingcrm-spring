package com.app.monolightdemo.controller;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.monolightdemo.dto.OrganizationDTO;
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
		
		String url = request.getRequestURL() + "?";
		
		if(!search.equals("") || !trashed.equals(""))
			url = url + "search=" + search + "&trashed=" + trashed + "&";
		
		
		Map<String, Object> organizations = organizationService.getOrganizations(url, search, trashed, page);
		
		result.put("organizations", organizations);
		
		Map<String, String> filters = new HashMap<>();
		filters.put("search", search);
		filters.put("trashed", trashed);
		result.put("filters", filters);
		
		System.err.println(request.getRequestURL() + " " + request.getRequestURI()+ " " + request.getQueryString());
		
		return inertia.generateResponse("Organizations/Index", result);
	}
	@RequestMapping(path = "/{id}/edit" ,method = RequestMethod.GET )
	public Object edit(@PathVariable(name = "id") Integer id) {
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("organization", organizationService.getOrganization(id));
		
		return inertia.generateResponse("Organizations/Edit", result);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Object update(@PathVariable(name = "id") Integer id, @RequestBody OrganizationDTO organizationDTO,
			HttpServletRequest request, HttpServletResponse response ) throws IOException {
		
		return inertia.generateResponse("Organizations/Edit", new HashMap<>());
		
	}
}
