package com.app.monolightdemo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.app.monolightdemo.entity.Organization;
import com.app.monolightdemo.repository.OrganizationRepository;
import com.app.monolightdemo.service.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public Object getOrganizations(String search, String trashed, Integer page) {
		// TODO Auto-generated method stub
		
	
		List<Organization> organizations = organizationRepository.findByName(search);
		
		
		return new HashMap<String, Object>().put("data", organizations);
	}
	
	@Override
	public Map<String, Object> getLinks(String url, String search, String trashed, Integer page) {
		// TODO Auto-generated method stub
		Pageable paging = PageRequest.of(page, 10);
		Page<Organization> organPage = organizationRepository.findByName(search, paging);
		return null;
	}
}
