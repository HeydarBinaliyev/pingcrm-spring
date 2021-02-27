package com.app.monolightdemo.repository;

import java.util.List;

import com.app.monolightdemo.dto.UserDTO;

public interface UserRepositoryCustom {
	
	public List<UserDTO> getAllUsers(String search, String trashed, String role);
}
