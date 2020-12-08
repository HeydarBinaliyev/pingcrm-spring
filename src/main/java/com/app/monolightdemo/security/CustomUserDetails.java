package com.app.monolightdemo.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.monolightdemo.entity.User;

public interface CustomUserDetails extends UserDetails{

	public User getUser();
	
}
