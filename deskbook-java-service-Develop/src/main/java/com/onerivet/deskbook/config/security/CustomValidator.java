package com.onerivet.deskbook.config.security;

import java.util.List;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

public class CustomValidator implements OAuth2TokenValidator<Jwt> {

	private final List<String> audiences;

	public CustomValidator(List<String> audiences) {
		this.audiences= audiences;
	}

	@Override
	public OAuth2TokenValidatorResult validate(Jwt jwt) {
		System.out.println(audiences);
		if (jwt.getAudience().containsAll(audiences)) {// Get audience in yml file "Deskbook"
			return OAuth2TokenValidatorResult.success();// No error
		} else {
			OAuth2Error error = new OAuth2Error(OAuth2ErrorCodes.INVALID_REQUEST, "Invalid audience", null);// It will return any error if happened
			return OAuth2TokenValidatorResult.failure(error); // return failure(Arrays.asList(errors)); 
		}
	}
}
