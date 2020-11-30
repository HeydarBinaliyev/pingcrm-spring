package com.app.monolightdemo.repository;

import java.util.List;

import com.app.monolightdemo.dto.AuthorityDTO;


public interface AuthorityRepository {
	
	List<AuthorityDTO> getAll(String name);
}
