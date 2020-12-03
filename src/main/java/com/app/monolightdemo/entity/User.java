package com.app.monolightdemo.entity;






import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	@NaturalId(mutable = false)
	private String email;
	
	
	@Column(name = "account_id")
	private Integer acccountId;
	
	@Column(name = "owner")
	private Integer owner;
	
	@Column(name = "photo_path")
	private String photoPath;
	
	@JsonIgnore
	@Column(name = "remember_token")
	private String rememberToken;
	
	@JsonIgnore
	@Column(name = "created_at")
	private Date created_at;
	
	@JsonIgnore
	@Column(name = "updated_at")
	private Date updated_at;
	
	@JsonIgnore
	@Column(name = "deleted_at")
	private Date deleted_at;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", insertable=false, updatable=false)
	private Account account;
	

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

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
	
}
