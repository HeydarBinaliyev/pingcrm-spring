package com.app.monolightdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.monolightdemo.dto.LinkDTO;
import com.app.monolightdemo.entity.Organization;
import com.app.monolightdemo.repository.OrganizationRepository;
import com.app.monolightdemo.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public Object getOrganizations(String search, String trashed, Integer page) {
		// TODO Auto-generated method stub
		Pageable paging = PageRequest.of(page-1, 10);
	
		Page<Organization> organizations = organizationRepository.findByNameContaining(search, paging);
		
		return organizations.getContent();
	}
	
	@Override
	public Object getLinks(String url, String search, String trashed, Integer page) {
		// TODO Auto-generated method stub
		List<LinkDTO> links = new ArrayList<>();
		Pageable paging = PageRequest.of(page, 10);
		Page<Organization> organPage = organizationRepository.findByNameContaining(search, paging);
		
		int totalPages = organPage.getTotalPages();
		for(int i=1; i <= totalPages; i++ ) {
			
			if(i == 1) {
				LinkDTO previous = new LinkDTO(page == 1?null:(url + "?page=" + (page-1)),"Previous", false);
				links.add(previous);
			}
		
			LinkDTO link = new LinkDTO(url + "?page=" + i, String.valueOf(i), (page == i || (page == 1 && i==1) ?true:false));
			links.add(link);
			
			if(i == totalPages) {
				int nextPage = page + 1;
				String _url = totalPages == 1 || page == totalPages ? null: url + "?page=" + nextPage;
				LinkDTO next = new LinkDTO(_url, "Next", false);
				links.add(next);
			}
		}
		return links;
	}

}
