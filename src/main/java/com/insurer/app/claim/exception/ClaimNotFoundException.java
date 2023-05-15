package com.insurer.app.claim.exception;

import org.springframework.beans.factory.annotation.Value;

public class ClaimNotFoundException extends RuntimeException {
	
	@Value("${exception.claimNotFoundException}")
    private String mensagem;
	
	public ClaimNotFoundException() {
		System.out.println(mensagem);
	}
	
}
