package com.app.monolightdemo.dto;



public class LinkDTO{

	private String url;
	private String label;
	private boolean active;
	
	
	
	public LinkDTO(String url, String label, boolean active) {
		this.url = url;
		this.label = label;
		this.active = active;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
