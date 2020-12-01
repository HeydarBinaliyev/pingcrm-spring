package com.app.monolightdemo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;

import com.app.monolightdemo.entity.Authority;
import com.app.monolightdemo.entity.User;
import com.app.monolightdemo.repository.UserRepository;



@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

	@Autowired 
	UserRepository userRepository;
	
	
	 
	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserName(username);
		
		if(user == null )
			return null;
		
		Set <Authority> grantedAuthorities = new HashSet < > ();
		
		grantedAuthorities = user.getAuhtorities();
		
		return new UserDetailsImpl(user , grantedAuthorities);
	}
	

}
