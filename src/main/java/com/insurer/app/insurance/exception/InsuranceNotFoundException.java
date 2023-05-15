package com.insurer.app.insurance.exception;

import org.springframework.beans.factory.annotation.Value;

public class InsuranceNotFoundException extends RuntimeException {
	
	@Value("${exception.insuranceNotFoundException}")
    private String mensagem;
	
	public InsuranceNotFoundException() {
		System.out.println(mensagem);
	}
	
}
