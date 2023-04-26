//package com.onerivet.security;
//
//import org.aspectj.weaver.patterns.AndTypePattern;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
////@Configuration
////@EnableWebSecurity
//public class EmployeeSecurity  {//extends WebSecurityConfigurerAdapter{
//
//	
//// Pop up BASED basic authentication for credentials
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		
////		http.authorizeRequests()
////		.anyRequest()
////		.authenticated()
////		.and()
////		.httpBasic();
////	}
//
//// BASIC authentication for credentials
//// Put restriction on particular api 	
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		
////		http.authorizeRequests()
////		.antMatchers("/employee/**").permitAll()
////		.anyRequest()
////		.authenticated()
////		.and()
////		.httpBasic();
////	}
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
////In memory 
//	@Bean
//	protected UserDetailsService userDetailsServiec() {
//		
//		UserDetails abhishek = User.builder()
//		.username("abhishek")
//		.password(passwordEncoder.encode("abhi@123"))
//		.roles("student")
//		.build();
//		return  new InMemoryUserDetailsManager(abhishek);
//	}
//}
