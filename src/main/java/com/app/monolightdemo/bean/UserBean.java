package com.app.monolightdemo.bean;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.app.monolightdemo.entity.User;

@Component
@SessionScope
public class UserBean {
	
	
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
