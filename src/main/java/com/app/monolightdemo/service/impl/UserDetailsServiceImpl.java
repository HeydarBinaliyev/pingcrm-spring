package com.app.monolightdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;


import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.repository.UserRepository;



@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

	@Autowired 
	UserRepository userRepository;
	
	
	 
	@Override
	public UserDetails loadUserByUsername(String email) {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserName(email);
		
		if(user == null )
			return null;
		
		return new UserDetailsImpl(user);
	}
	

}
