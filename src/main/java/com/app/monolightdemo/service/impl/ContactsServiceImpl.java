package com.app.monolightdemo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.monolightdemo.dto.LinkDTO;
import com.app.monolightdemo.entity.Contacts;
import com.app.monolightdemo.repository.ContactsRepositoy;
import com.app.monolightdemo.service.ContactsService;
import com.app.monolightdemo.utils.PagingUtil;

@Service
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	ContactsRepositoy contactsRepository;

	@Autowired
	PagingUtil paggingUtil;
	
	@Override
	public Map<String, Object> getContacts(String url, String search, String trashed, Integer page) {
		// TODO Auto-generated method stub

		Map<String, Object> result = new HashMap<>();

		Pageable pageable = PageRequest.of(page - 1, 10);
		
		String[] params = search.split(" ");
		String first_name = "%%";
		String last_name ="%%";
		
		if(params.length >0)
			first_name = "%" + params[0].trim() + "%";
		if(params.length >1)
			last_name = "%" + params[1].trim() + "%";
		
		Page<Map<String, Object>> contacts = contactsRepository.findByNameAndSurname(first_name, last_name, pageable);
		
		List<LinkDTO> links = paggingUtil.createpagingList(url, page, contacts.getTotalPages());
		
		result.put("links", links);
		result.put("data", contacts.getContent());

		return result;
	}

}
