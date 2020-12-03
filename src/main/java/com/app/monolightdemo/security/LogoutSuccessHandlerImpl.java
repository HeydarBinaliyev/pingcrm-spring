package com.app.monolightdemo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.dto.UserDTO;


@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler{

	@Autowired
	ApplicationContext appContext;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("user: " + authentication.getName() + " logged out");
		response.setStatus(200);
		@SuppressWarnings("unchecked")
		List<UserDTO> loggedInUsers = (ArrayList<UserDTO>) appContext.getBean("sessionUsers");
		Iterator<UserDTO> iterator  = loggedInUsers.iterator();
		while(iterator.hasNext()) {
			UserDTO userDTO = iterator.next();
			if(userDTO.getEmail().equals(authentication.getName()))
				iterator.remove();
		}
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		
	    redirectStrategy.sendRedirect(request, response, "/");
			
	}
}
