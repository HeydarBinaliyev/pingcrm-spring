package com.app.monolightdemo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;
    
    @ManyToMany(mappedBy="authorities" ,fetch = FetchType.LAZY)
    private Set<User> users;
    
    @OneToMany(cascade=CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="authority_id")
	private List<AuthorityMenu> authorityMenuList;
    
    public Authority() {}
    public Authority(AuthorityType name) {
        this.name = name;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AuthorityType getName() {
		return name;
	}
	public void setName(AuthorityType name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public List<AuthorityMenu> getAuthorityMenuList() {
		return authorityMenuList;
	}
	public void setAuthorityMenuList(List<AuthorityMenu> authorityMenuList) {
		this.authorityMenuList = authorityMenuList;
	}
	
	
    
    
}