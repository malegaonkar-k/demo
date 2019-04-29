package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApiSecurity extends WebSecurityConfigurerAdapter {

	private static final String SIGNUP_URL = "/users";

	//@Autowired
	//UserDetailsService userDetailService;

	// @Autowired
	// BCryptPasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// Various authentication to follow set username and password and
		// mention the role
		
		 auth.inMemoryAuthentication()
         .withUser("user").password("{noop}password").roles("USER")
         .and()
         .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// //various authorizations to follow
		// mention which role can access which url

		 http
         //HTTP Basic authentication
         .httpBasic()
         .and()
         .authorizeRequests()
         .antMatchers(HttpMethod.GET, "/users").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/users/").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/users/*").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/users/**").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/demo/users").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/demo/users/").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/demo/users/*").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/demo/users/**").hasRole("USER")
         
         .and()
         .csrf().disable()
         .formLogin().disable();

	}

}
