package com.app.monolightdemo.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.monolightdemo.entity.Authority;
import com.app.monolightdemo.entity.User;




public class UserDetailsImpl  implements UserDetails{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	User user;
	Set<GrantedAuthority> authorities=null;;
	
	public UserDetailsImpl(User user , Set<Authority> authorities){
		this.user = user;
		this.authorities = new HashSet<GrantedAuthority>();
		for (Authority grantedAuthority : authorities) {
			System.err.println(grantedAuthority.getName().toString());
			this.authorities.add(new SimpleGrantedAuthority(grantedAuthority.getName().toString()));
		}
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		
		return  user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
