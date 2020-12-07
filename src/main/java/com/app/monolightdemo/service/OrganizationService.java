package com.app.monolightdemo.service;



import java.util.Map;

import com.app.monolightdemo.dto.OrganizationDTO;
import com.app.monolightdemo.entity.Organization;




public interface OrganizationService {

	public Map<String, Object> getOrganizations(String url, String search, String trashed, Integer page);
	
	public Organization getOrganization(Integer id);
	
	public void updateOrganization(OrganizationDTO organization);
	
	public void deleteOrganization(Integer id);
	
	public void restoreOrganization(Integer id);
	
	public void storeOrganization(OrganizationDTO organizationDTO) throws Exception;
}
