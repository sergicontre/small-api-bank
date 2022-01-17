package com.small.api.bank.architecture.domain.dto;

import java.io.Serializable;


public class JwtResponseDto implements Serializable {

	private static final long serialVersionUID = -8275527742691759227L;
	
	private final String jwttoken;

	public JwtResponseDto(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
