package com.onerivet.deskbook.config.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		  .cors()
		.and()
		  .authorizeHttpRequests( 
				  (authorize) -> authorize.requestMatchers("/api/deskbook").permitAll()
				  .anyRequest().authenticated()
				  )
		  .oauth2ResourceServer().jwt();// JwtConfigurer class
		// HttpSecurity have the method   .authorizeHttpRequests( )
		//DefaultSecurityFilterChain build = http.build();
		//public final class DefaultSecurityFilterChain implements SecurityFilterChain {
		return http.build();
	}

	
	@Bean
	JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties) {// It is interface which is decode the JWT token

		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri()).build();
		OAuth2TokenValidator<Jwt> defaultValidator = new JwtTimestampValidator();
		OAuth2TokenValidator<Jwt> audienceValidator = new CustomValidator(properties.getJwt().getAudiences());
		jwtDecoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(defaultValidator, audienceValidator));
		return jwtDecoder;
	}

	/*@ConfigurationProperties(prefix = "spring.security.oauth2.resourceserver")
public class OAuth2ResourceServerProperties {

	  inner class Jwt{
	List<String > String 
	
	* getAudiences());
	
	}
	
	
	
	
	
	
	
	
	*/
}
