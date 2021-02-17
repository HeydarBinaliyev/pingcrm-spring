package com.app.monolightdemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
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
	public Object edit(@PathVariable(name = "id") Integer id) {
		
		Map<String, Object> result = new HashMap<>();
		ContactsDTO contactsDTO = contactService.getContact(id);
		result.put("contact", contactsDTO);
		List<Map<String, Object>> organizations = organizationService.findAll();
		
		result.put("organizations", organizations);
		
		return inertia.generateResponse("Contacts/Edit", result);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Object update(@PathVariable(name = "id",required = true) Integer id, @RequestBody ContactsDTO contactDTO) {
		
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> flash = new HashMap<>();
		
		contactDTO.setId(id);
		
		contactService.updateContact(contactDTO);
		
		flash.put("success", "Contact updated.");
		result.put("flash", flash);
		return inertia.generateResponse(null, result);
	}
	@RequestMapping(path = "/{id}",  method = RequestMethod.DELETE)
	public Object delete(@PathVariable(name = "id",  required = true) Integer id) {

		Map<String, Object> result = new HashMap<>();
		Map<String, Object> flash = new HashMap<>();
		
		contactService.deleteContact(id);
		
		flash.put("success", "Contact deleted.");
		result.put("flash", flash);
		
		return inertia.generateResponse(null, result);
	}
	
	@RequestMapping(path = "/restore/{id}",  method = RequestMethod.PUT)
	public Object restore(@PathVariable(name = "id",  required = true) Integer id) {

		Map<String, Object> result = new HashMap<>();
		Map<String, Object> flash = new HashMap<>();
		
		contactService.restoreContact(id);
		
		flash.put("success", "Contact restored.");
		result.put("flash", flash);
		
		return inertia.generateResponse(null, result);
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public Object create() {
		
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> organizations = organizationService.findAll();
		
		result.put("organizations", organizations);
		
		return inertia.generateResponse("Contacts/Create", result);
		
	}
	
	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(@RequestBody ContactsDTO contactDTO, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException  {
		
		Map<String, Object> flash = new HashMap<>();
		
		try {
			contactService.storeContact(contactDTO);
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			Map<String, Object> errors = new HashMap<>();
			errors.put("name", "Contact could not created.");
			request.getSession().setAttribute("errors", errors);
			response.sendRedirect("/contacts/create");
			return;
		}
		
		flash.put("success", "Contact created.");
		
		request.getSession().setAttribute("flash", flash);
		
		response.sendRedirect("/contacts");
		
	}
}
