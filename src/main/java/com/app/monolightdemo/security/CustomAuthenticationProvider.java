package com.app.monolightdemo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.dto.UserDTO;
import com.app.monolightdemo.exception.CustomLoginException;



@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	ApplicationContext appContext;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();

		String password = authentication.getCredentials().toString();

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		if (userDetails == null)
			throw new CustomLoginException("error.login.102");

		boolean passwordMatches = new BCryptPasswordEncoder().matches(password, userDetails.getPassword());

		if (!passwordMatches)
			throw new CustomLoginException("error.login.103");
		
		if(userDetails.getAuthorities().isEmpty())
			throw new CustomLoginException("error.login.104");
		
		@SuppressWarnings("unchecked")
		List<UserDTO> loggedInUsers = (List<UserDTO>) appContext.getBean("sessionUsers");
		for(UserDTO user : loggedInUsers)
			if(user.getName().equals(username))
				throw new CustomLoginException("error.login.106");

		return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}