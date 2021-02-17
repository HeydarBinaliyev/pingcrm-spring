package com.app.monolightdemo.dto;

import java.io.Serializable;
import java.util.Date;



public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
		
	private String name;
	
	private String email;

	private Boolean owner;

	private String photo;

	private Date deleted_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean getOwner() {
		return owner;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
	
	
	
}
