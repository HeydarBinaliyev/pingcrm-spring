package com.app.monolightdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.app.monolightdemo.exception.CustomLoginException;
import com.app.monolightdemo.utils.ServiceUtils;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	ApplicationContext appContext;

	@Autowired
	ServiceUtils serviceUtils;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();

		String password = authentication.getCredentials().toString();

		CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(email);

		if (userDetails == null)
			throw new CustomLoginException("error.login.102");

		boolean passwordMatches = new BCryptPasswordEncoder().matches(password, userDetails.getPassword());

		if (!passwordMatches)
			throw new CustomLoginException("error.login.103");

		serviceUtils.populateUserBean(userDetails.getUser());

		return new UsernamePasswordAuthenticationToken(email, userDetails.getPassword(), userDetails.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}