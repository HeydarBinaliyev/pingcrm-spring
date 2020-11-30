package com.app.monolightdemo.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String email;
	private String password;
	List<AuthorityDTO> authorities;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AuthorityDTO> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<AuthorityDTO> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String roles="(";
		for (AuthorityDTO role : this.authorities) {
			roles = roles.concat(role.getName());
			roles = roles.concat(",");
		}
		roles = roles.substring(0, roles.length() - 1);
		roles = roles.concat(")");
		
		return "name:" + this.name + ", email:" + this.email + ", roles:"+roles;
	}
	
	
}
