package com.app.monolightdemo.utils;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.app.monolightdemo.bean.UserBean;
import com.app.monolightdemo.entity.User;

@Component
public class ServiceUtils {

	@Autowired
	@Lazy
	UserBean userBean;

	@Autowired
	@Lazy
	private MessageSource messageSource;

	public void populateUserBean(User user) {
		userBean.setUser(user);
	}

	public String getMessage(String code) {
		Locale locale = new Locale("en");
		String msg = messageSource.getMessage(code, null, "Error code not found!", locale);
		return msg;
	}

}
