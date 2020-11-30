package com.app.monolightdemo.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.bean.UserBean;
import com.app.monolightdemo.exception.CustomLoginException;
import com.app.monolightdemo.exception.GeneralException;




@Component
public class ServiceUtils {

	@Autowired
	@Lazy
	UserBean userBean;
	
	@Autowired
	@Lazy
	private MessageSource messageSource;
	
	public  void populateUserBean() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
		 if(!authentication.isAuthenticated() || authentication ==null)
			 throw new CustomLoginException("error.login.101");
		 
		 userBean.setUserName(authentication.getName());
		 userBean.setRoles(authentication.getAuthorities());
	}
	public  void populateUserBean(String authority) throws GeneralException {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 userBean.setUserName(authentication.getName());
		 userBean.setRoles(authentication.getAuthorities());
		 
		 if(!userBean.getRoles().contains(new SimpleGrantedAuthority(authority)))
			 throw new GeneralException("error.login.101");
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
