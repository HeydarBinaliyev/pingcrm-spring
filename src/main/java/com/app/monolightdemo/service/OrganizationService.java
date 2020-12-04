package com.app.monolightdemo.service;



import org.springframework.stereotype.Service;


public interface OrganizationService {

	public Object getOrganizations(String search, String trashed, Integer page);
	public Object getLinks(String url ,String search, String trashed, Integer page);
}
