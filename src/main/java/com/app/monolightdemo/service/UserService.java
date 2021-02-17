package com.app.monolightdemo.service;

import java.util.List;

import com.app.monolightdemo.dto.UserDTO;


public interface UserService {

	public List<UserDTO> getUsers(String search, String trashed, String role);
	
}
