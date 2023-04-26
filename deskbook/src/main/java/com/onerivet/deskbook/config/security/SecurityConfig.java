package com.onerivet.deskbook.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		CorsConfigurer<HttpSecurity> cors = http.cors();
//		
//		HttpSecurity and = cors.and();
//		
//		//AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizeHttpRequests = and.authorizeHttpRequests();
//		AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authenticated = and.authorizeHttpRequests().requestMatchers("/api/deskbook").permitAll().anyRequest().authenticated();
//		OAuth2ResourceServer().jwt();
//		return http.build();
	
		http
		  .cors()
		.and()
		  .authorizeHttpRequests( 
				  (authorize) -> authorize.requestMatchers("/api/deskbook").permitAll()
				  .anyRequest().authenticated()
				  )
		  .oauth2ResourceServer().jwt();
		

		return http.build();
	}
}
