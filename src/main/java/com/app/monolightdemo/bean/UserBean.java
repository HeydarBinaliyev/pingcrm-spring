package com.app.monolightdemo.bean;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.app.monolightdemo.entity.User;

@Component
@SessionScope
public class UserBean {
	
	
	
	private User user;
	
	private Map<String, Object> userData;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.setUserData(this.user);
	}
	
	public Map<String, Object> getUserData() {
		return userData;
	}

	public void setUserData(User user) {
		userData =  new HashMap<>();
		Map<String, Object> account = new HashMap<>();
		account.put("id", getUser().getAccount().getId());
		account.put("name", getUser().getAccount().getName());
		userData.put("account", account);
		userData.put("id", getUser().getId());
		userData.put("first_name", getUser().getFirst_name());
		userData.put("last_name", getUser().getLast_name());
		userData.put("email", getUser().getEmail());
		userData.put("role", null);
	}
	
	
}
