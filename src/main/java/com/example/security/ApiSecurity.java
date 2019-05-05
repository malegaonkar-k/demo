package com.example.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.CorsFilter;

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
		 .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
		 .cors()
		 .and()
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
	
	  @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
	        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }

}
