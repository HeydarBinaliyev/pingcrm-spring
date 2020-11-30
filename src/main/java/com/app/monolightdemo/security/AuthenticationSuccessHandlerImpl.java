package com.app.monolightdemo.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.bean.UserBean;
import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.utils.ServiceUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{

	@Autowired
	ServiceUtils serviceUtils;
	
	@Autowired
	@Lazy
	UserBean userBean;
	@Autowired
	ApplicationContext appContext;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		serviceUtils.populateUserBean();
		@SuppressWarnings("unchecked")
		List<UserDTO> loggedInUsers = (List<UserDTO>) appContext.getBean("sessionUsers");
		UserDTO loggedInUser = new UserDTO();
		loggedInUser.setName(userBean.getUserName());
		loggedInUsers.add(loggedInUser);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", userBean.getUserName());
		data.put("roles", userBean.getRoles());
		response.setStatus(HttpStatus.OK.value());
		
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, data);
		out.flush();
		System.err.println("logged in user: " + userBean.getUserName());
		
	}
}
