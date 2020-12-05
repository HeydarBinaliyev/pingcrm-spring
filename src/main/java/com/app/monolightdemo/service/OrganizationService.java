package com.app.monolightdemo.service;



import java.util.Map;

import com.app.monolightdemo.entity.Organization;




public interface OrganizationService {

	public Map<String, Object> getOrganizations(String url, String search, String trashed, Integer page);
	public Organization getOrganization(Integer id);
}
