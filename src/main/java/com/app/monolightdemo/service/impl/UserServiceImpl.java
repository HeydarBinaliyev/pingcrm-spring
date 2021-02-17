package com.app.monolightdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.repository.UserRepository;
import com.app.monolightdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<UserDTO> getUsers(String search, String trashed, String role) {
		
		return userRepository.getAllUsers(search, trashed, role);
	}
}
