package com.einfo.SmartInventoryManagement.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class securityConfig  {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeHttpRequests((request)-> request.requestMatchers("/").authenticated()
				.anyRequest().permitAll()).oauth2Login();
		return http.build();
	} 
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf(c->c
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())	
				);
		
//		String cookieName="myCookie";
//		String cookieValue="01112001";
//		Cookie customeCookie=new Cookie(cookieName,  cookieValue);
//		customeCookie.setMaxAge(300);
//		customeCookie.setPath("/");
//		response.addCookie(customeCookie);
	}
}
