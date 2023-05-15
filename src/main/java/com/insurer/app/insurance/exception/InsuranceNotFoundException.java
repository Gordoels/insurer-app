package com.insurer.app.insurance.exception;

import org.springframework.beans.factory.annotation.Value;

public class InsuranceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 4049488316801178044L;
	
	@Value("${exception.insuranceNotFoundException}")
    private String mensagem;
	
	public InsuranceNotFoundException() {
		System.out.println(mensagem);
	}
	
}
