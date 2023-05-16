package com.insurer.app.car.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class CarNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1379716571048609958L;
	
	private static String messageKey = "exception.carNotFoundException";
    private Locale locale;
    
    public CarNotFoundException() {
        this(messageKey, Locale.getDefault());
    }

    public CarNotFoundException(String messageKey, Locale locale) {
    	CarNotFoundException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
