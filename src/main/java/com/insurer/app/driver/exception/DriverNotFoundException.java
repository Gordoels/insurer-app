package com.insurer.app.driver.exception;

import org.springframework.beans.factory.annotation.Value;

public class DriverNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1474902126550642581L;
	
	@Value("${exception.driverNotFoundException}")
    private String mensagem;
	
	public DriverNotFoundException() {
		System.out.println(mensagem);
    }
	
	
}
