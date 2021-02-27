package com.app.monolightdemo.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;


import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.repository.UserRepository;
import com.app.monolightdemo.security.UserDetailsImpl;



@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

	@Autowired 
	UserRepository userRepository;
	 
	@Override
	public UserDetails loadUserByUsername(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		
		if(!user.isPresent())
			return null;
		
		return new UserDetailsImpl(user.get());
	}
	

}
