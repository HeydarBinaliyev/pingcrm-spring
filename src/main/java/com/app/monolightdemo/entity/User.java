package com.app.monolightdemo.entity;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	@NaturalId(mutable = false)
	private String email;
	
	
	@ManyToMany(cascade=CascadeType.DETACH , fetch = FetchType.EAGER)
    @JoinTable(	name="user_authority", 
    			joinColumns={@JoinColumn(referencedColumnName="id")},
    			inverseJoinColumns={@JoinColumn(referencedColumnName="id")})  
    private Set<Authority> authorities;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Authority> getAuhtorities() {
		return authorities;
	}
	public void setAuhtorities(Set<Authority> auhtorities) {
		this.authorities = auhtorities;
	}
	
	
	
}
