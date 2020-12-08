package com.app.monolightdemo.service;

import java.util.Map;

import com.app.monolightdemo.dto.ContactsDTO;

public interface ContactsService {

	public Map<String, Object> getContacts(String url, String search, String trashed, Integer page);
	public ContactsDTO getContact(Integer id);
}
