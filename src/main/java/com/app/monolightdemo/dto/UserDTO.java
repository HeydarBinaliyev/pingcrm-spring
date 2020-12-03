package com.app.monolightdemo.dto;

import java.io.Serializable;



public class UserDTO implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
		
	private String first_name;
	
		
	private String last_name;
	
	private String password;
	

	private String email;
	
	
	
	private Integer acccountId;
	
	private Integer owner;
	

	private String photoPath;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getAcccountId() {
		return acccountId;
	}


	public void setAcccountId(Integer acccountId) {
		this.acccountId = acccountId;
	}


	public Integer getOwner() {
		return owner;
	}


	public void setOwner(Integer owner) {
		this.owner = owner;
	}


	public String getPhotoPath() {
		return photoPath;
	}


	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	
	
	
}
