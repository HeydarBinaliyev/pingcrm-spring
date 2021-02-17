package com.app.monolightdemo.service;

import java.util.Map;

import com.app.monolightdemo.dto.ContactsDTO;

public interface ContactsService {

	public Map<String, Object> getContacts(String url, String search, String trashed, Integer page);
	
	public ContactsDTO getContact(Integer id);
	
	public void updateContact(ContactsDTO contactDTO);
	
	public void deleteContact(Integer id);
	
	public void restoreContact(Integer id);
	
	public void storeContact(ContactsDTO contactDTO);
	
}
