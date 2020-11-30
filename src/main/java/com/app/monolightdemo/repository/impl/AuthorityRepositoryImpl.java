package com.app.monolightdemo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.monolightdemo.dto.AuthorityDTO;
import com.app.monolightdemo.entity.Authority;
import com.app.monolightdemo.repository.AuthorityRepository;


@Repository
@Transactional
public class AuthorityRepositoryImpl implements AuthorityRepository{

	@Autowired
	EntityManager em;
	
	@Override
	public List<AuthorityDTO> getAll(String name) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Authority");
		//query.setParameter("name", "%" + name + "%");
		query.setMaxResults(10);
		@SuppressWarnings("unchecked")
		List<Authority> authorities = query.getResultList();
		List<AuthorityDTO> authoritiesDTO = new ArrayList<AuthorityDTO>();
		authorities.forEach(authority->{
			AuthorityDTO authorityDTO = new AuthorityDTO();
			authorityDTO.setId(authority.getId());
			authorityDTO.setName(authority.getName().toString());
			authoritiesDTO.add(authorityDTO);
		});
		return authoritiesDTO;
	}
}
