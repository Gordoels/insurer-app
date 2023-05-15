package com.insurer.app.car.exception;

import org.springframework.beans.factory.annotation.Value;

public class CarNotFoundException extends RuntimeException {
	
	@Value("${exception.carNotFoundException}")
    private String mensagem;
	
	public CarNotFoundException() {
		System.out.println(mensagem);
	}
	
}
