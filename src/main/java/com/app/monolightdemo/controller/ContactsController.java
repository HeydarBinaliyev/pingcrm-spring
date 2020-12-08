package com.app.monolightdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.monolightdemo.dto.ContactsDTO;
import com.app.monolightdemo.inertia.Inertia;
import com.app.monolightdemo.service.ContactsService;
import com.app.monolightdemo.service.OrganizationService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

	@Autowired
	Inertia inertia;
	@Autowired
	ContactsService contactService;

	@Autowired
	OrganizationService organizationService;
	
	@GetMapping
	public Object index(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "trashed", defaultValue = "") String trashed,
			@RequestParam(name = "page", defaultValue = "1") Integer page, HttpServletRequest request) {

		Map<String, Object> result = new HashMap<>();

		String url = request.getRequestURL() + "?";

		if (!search.equals("") || !trashed.equals(""))
			url = url + "search=" + search + "&trashed=" + trashed + "&";

		Map<String, Object> contacts = contactService.getContacts(url, search, trashed, page);

		result.put("contacts", contacts);

		Map<String, String> filters = new HashMap<>();
		filters.put("search", search);
		filters.put("trashed", trashed);
		result.put("filters", filters);

		return inertia.generateResponse("Contacts/Index", result);
	}
	
	@RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
	public Object index(@PathVariable(name = "id") Integer id) {
		
		Map<String, Object> result = new HashMap<>();
		ContactsDTO contactsDTO = contactService.getContact(id);
		result.put("contact", contactsDTO);
		List<Map<String, Object>> organizations = organizationService.findAll();
		
		result.put("organizations", organizations);
		
		return inertia.generateResponse("Contacts/Edit", result);
	}
}
