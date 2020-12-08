package com.app.monolightdemo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.monolightdemo.dto.ContactsDTO;
import com.app.monolightdemo.dto.LinkDTO;
import com.app.monolightdemo.entity.Contacts;
import com.app.monolightdemo.entity.Organization;
import com.app.monolightdemo.repository.ContactsRepositoy;
import com.app.monolightdemo.repository.OrganizationRepository;
import com.app.monolightdemo.service.ContactsService;
import com.app.monolightdemo.utils.PagingUtil;

@Service
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	ContactsRepositoy contactsRepository;

	@Autowired
	OrganizationRepository organizationRepository;
	
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
		
		Page<Contacts> contacts = null;
		
		if(trashed.equals("only"))
			contacts = contactsRepository.findByNameAndSurnameAndOnlyTrashed(first_name, last_name, pageable);
		else
			contacts = contactsRepository.findByNameAndSurname(first_name, last_name, pageable);
		
		List<Map<String, Object>> contactList = new ArrayList<>();
		
		contacts.getContent().forEach(contact->{
			Map<String, Object> row = new HashMap<>();
			row.put("id", contact.getId());
			row.put("city", contact.getCity());
			row.put("phone", contact.getPhone());
			row.put("deleted_at", contact.getDeleted_at());
			row.put("name", contact.getFirst_name() + " " + contact.getLast_name());
			Optional<Organization> organization = organizationRepository.findById(contact.getOrganization_id());
			Map<String, Object> organizationData = new HashMap<>();
			organizationData.put("name", organization.isEmpty()?"null":organization.get().getName());
			row.put("organization", organizationData);
			contactList.add(row);
		});
		
		List<LinkDTO> links = paggingUtil.createpagingList(url, page, contacts.getTotalPages());
		
		result.put("links", links);
		result.put("data", contactList);

		return result;
	}

	@Override
	public ContactsDTO getContact(Integer id) {
		// TODO Auto-generated method stub
		
		Contacts contact = contactsRepository.findById(id).get();
		ModelMapper modelMapper = new ModelMapper();
		TypeMap<Contacts, ContactsDTO> mapper =  modelMapper.createTypeMap(Contacts.class, ContactsDTO.class);
		mapper.addMappings(m -> m.skip(ContactsDTO::setAccount_id));
		mapper.addMappings(m->m.skip(ContactsDTO::setOrganization));
		ContactsDTO contactDTO = mapper.map(contact);
		
		return contactDTO;
	}
}
