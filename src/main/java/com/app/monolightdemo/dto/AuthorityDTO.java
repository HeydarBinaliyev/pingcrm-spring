package com.app.monolightdemo.dto;

import java.util.List;

public class AuthorityDTO {

	private Integer id;
	private String name;
	
	private List<MenuDTO> menus;
	
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
	public List<MenuDTO> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuDTO> menus) {
		this.menus = menus;
	}
	
	
}
