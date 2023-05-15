package com.insurer.app.customer.exception;

import org.springframework.beans.factory.annotation.Value;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5167359807360729419L;
	
	@Value("${exception.customerNotFoundException}")
    private String mensagem;
	
	public CustomerNotFoundException() {
		System.out.println(mensagem);
	}

}
