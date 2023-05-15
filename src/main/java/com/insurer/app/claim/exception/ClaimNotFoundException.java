package com.insurer.app.claim.exception;

import org.springframework.beans.factory.annotation.Value;

public class ClaimNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -3074858174772838364L;
	
	@Value("${exception.claimNotFoundException}")
    private String mensagem;
	
	public ClaimNotFoundException() {
		System.out.println(mensagem);
	}
	
}
