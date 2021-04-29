package com.app.monolightdemo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.monolightdemo.bean.UserBean;
import com.app.monolightdemo.dto.LinkDTO;
import com.app.monolightdemo.dto.OrganizationDTO;
import com.app.monolightdemo.entity.Organization;
import com.app.monolightdemo.repository.OrganizationRepository;
import com.app.monolightdemo.service.OrganizationService;
import com.app.monolightdemo.utils.PagingUtil;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	UserBean userBean;
	@Autowired
	PagingUtil pagingUtil;
	
	@Override
	public Map<String, Object> getOrganizations(String url, String search, String trashed, Integer page) {

		Map<String, Object> result = new HashMap<>();
		
		Pageable paging = PageRequest.of(page-1, 10);
	
		Page<Organization> organizations = organizationRepository.findByNameContainingOrderByName(search, paging);
		
		result.put("data", organizations.getContent());
		
		List<LinkDTO> links = pagingUtil.createPagingList(url, page, organizations.getTotalPages());
		
		result.put("links", links);
		
		return result;
	}
	
	@Override
	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		Optional<Organization> organization = organizationRepository.findById(id);
		return organization.get();
	}
	
	@Override
	public void updateOrganization(OrganizationDTO o) {
		// TODO Auto-generated method stub
		this.organizationRepository.updateOrganization(o.getId(), o.getAddress(), o.getCity(), o.getCountry(), 
					o.getEmail(), o.getName(), o.getPhone(), o.getPostal_code(), o.getRegion(), new Date());
		
	}
	
	@Override
	public void deleteOrganization(Integer id) {
		// TODO Auto-generated method stub
		this.organizationRepository.deleteOrganization(id, new Date());
	}
	
	@Override
	public void restoreOrganization(Integer id) {
		// TODO Auto-generated method stub
		this.organizationRepository.restoreOrganization(id);
	}
	
	@Override
	public void storeOrganization(OrganizationDTO organizationDTO) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		Organization organization = mapper.map(organizationDTO, Organization.class);
		organization.setCreated_at(new Date());
		organization.setUpdated_at(new Date());
		organization.setAccount_id(userBean.getUser().getAcccountId());
		organizationRepository.save(organization);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<Organization> organizations = organizationRepository.findAll();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		organizations.forEach(organization->{
			
			Map<String, Object> row = new HashMap<>();
			row.put("id", organization.getId());
			row.put("name", organization.getName());
			result.add(row);
			
		});
		return result;
	}

}
