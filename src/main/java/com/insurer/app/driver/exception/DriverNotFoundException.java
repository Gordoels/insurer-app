package com.insurer.app.driver.exception;

import org.springframework.beans.factory.annotation.Value;

public class DriverNotFoundException extends RuntimeException {
	
	@Value("${exception.driverNotFoundException}")
    private String mensagem;
	
	public DriverNotFoundException() {
		System.out.println(mensagem);
    }
	
	
}
