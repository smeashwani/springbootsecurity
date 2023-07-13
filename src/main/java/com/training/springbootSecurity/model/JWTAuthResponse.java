package com.training.springbootSecurity.model;

import lombok.Data;

@Data
public class JWTAuthResponse {
	private String accessToken;
	private String tokenType;
}
