package com.app.monolightdemo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;


import com.app.monolightdemo.entity.User;





public class UserDetailsImpl  implements CustomUserDetails{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	User user;
	Set<GrantedAuthority> authorities=null;;
	
	public UserDetailsImpl(User user){
		this.user = user;
		this.authorities = new HashSet<GrantedAuthority>();
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
		return user.getFirst_name();
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


	public User getUser() {
		return user;
	}
	

}
