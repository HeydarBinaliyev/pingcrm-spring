package com.app.monolightdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.app.monolightdemo.security.AccessDeniedHandlerImpl;
import com.app.monolightdemo.security.AuthenticationFailureHandlerImpl;
import com.app.monolightdemo.security.AuthenticationSuccessHandlerImpl;
import com.app.monolightdemo.security.CustomAuthenticationProvider;
import com.app.monolightdemo.security.LogoutSuccessHandlerImpl;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationFailureHandlerImpl authenticationFailureHandler;
	@Autowired
	CustomAuthenticationProvider authenticationProvider;
	@Autowired
	AccessDeniedHandlerImpl exceptionHandling;
	@Autowired
	AuthenticationSuccessHandlerImpl authenticationSuccessHandler;
	@Autowired
	LogoutSuccessHandlerImpl logoutSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/public/**", "/favicon.ico", "/login").permitAll().anyRequest().authenticated();
		//http.formLogin().loginPage("/login");
		http.formLogin().loginProcessingUrl("/login").failureHandler(authenticationFailureHandler).usernameParameter("username").passwordParameter("password");
		http.exceptionHandling().accessDeniedHandler(exceptionHandling);
		//http.formLogin().defaultSuccessUrl("/", true);
		http.formLogin().successHandler(authenticationSuccessHandler);
		//http.formLogin().failureForwardUrl("/login/error");
		http.logout().logoutSuccessHandler(logoutSuccessHandler);
        http.csrf().disable(); 
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		//auth.userDetailsService(userDetailsServise).passwordEncoder(new BCryptPasswordEncoder());
		auth.authenticationProvider(authenticationProvider);
	}
}
