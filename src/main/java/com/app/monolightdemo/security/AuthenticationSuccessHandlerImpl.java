package com.app.monolightdemo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.bean.UserBean;
import com.app.monolightdemo.utils.ServiceUtils;


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
		
		/*
		 * @SuppressWarnings("unchecked") List<UserDTO> loggedInUsers = (List<UserDTO>)
		 * appContext.getBean("sessionUsers"); UserDTO loggedInUser = new UserDTO();
		 * loggedInUser.setEmail(userBean.getUser().getEmail());
		 * loggedInUsers.add(loggedInUser);
		 */
		
		System.err.println("logged in user: " + userBean.getUser().getEmail());
		
		//RedirectStrategy redirect = new DefaultRedirectStrategy();
		response.setHeader("X-Inertia", "true");
		System.err.println("auth success");
		//redirect.sendRedirect(request, response, "/");
		response.sendRedirect("/");
	    
		}
}
