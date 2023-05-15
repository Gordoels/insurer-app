package com.insurer.app.customer.exception;

import org.springframework.beans.factory.annotation.Value;

public class CustomerNotFoundException extends RuntimeException {

	@Value("${exception.customerNotFoundException}")
    private String mensagem;
	
	public CustomerNotFoundException() {
		System.out.println(mensagem);
	}

}
