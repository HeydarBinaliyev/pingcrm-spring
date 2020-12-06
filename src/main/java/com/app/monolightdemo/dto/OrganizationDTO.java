package com.app.monolightdemo.dto;

import java.util.List;

public class OrganizationDTO {

	private Integer id;
	
	private Integer account_id;
	
	private String name;
	
	private String email;

	private String phone;
	
	
	private String address;
	

	private String city;
	
	
	private String region;
	
	
	private String country;
	
	
	private String postal_code;
	
	private AccountDTO account;
	
	private List<ContactsDTO> contacts;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAccount_id() {
		return account_id;
	}


	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostal_code() {
		return postal_code;
	}


	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}


	public AccountDTO getAccount() {
		return account;
	}


	public void setAccount(AccountDTO account) {
		this.account = account;
	}


	public List<ContactsDTO> getContacts() {
		return contacts;
	}


	public void setContacts(List<ContactsDTO> contacts) {
		this.contacts = contacts;
	}
	
	
	
	
}
