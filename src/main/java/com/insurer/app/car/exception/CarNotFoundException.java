package com.insurer.app.car.exception;

import org.springframework.beans.factory.annotation.Value;

public class CarNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1379716571048609958L;
	
	@Value("${exception.carNotFoundException}")
    private String mensagem;
	
	public CarNotFoundException() {
		System.out.println(mensagem);
	}
	
}
