package com.app.monolightdemo.service;

import java.util.Map;

public interface ContactsService {

	public Map<String, Object> getContacts(String url, String search, String trashed, Integer page);
}
