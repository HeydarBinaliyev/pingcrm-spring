package com.app.monolightdemo.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
	
	public  void populateUserBean(User user) {
		
		 userBean.setUser(user);
		 
	}
	

	public Locale getRequestLocale(HttpServletRequest request) {
		String country = request.getHeader("Accept-Language");
		if(country == null)
			country = "az";
		Locale locale = new Locale(country);
		return locale;
	}
	public String getMessage(HttpServletRequest request,String code) {
		Locale locale = this.getRequestLocale(request);
		String msg = messageSource.getMessage(code, null,"Error code not found!", locale);
		return msg;
	}
	public Map<String, Object> createOperationMessage(HttpServletRequest request, boolean success, String messageCode){
		Map<String, Object> result = new HashMap<String, Object>();
		String message = this.getMessage(request, messageCode);
		result.put("message", message);
		result.put("success", success);
		return result;
	}
}
