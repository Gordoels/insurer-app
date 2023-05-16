package com.insurer.app.cardriver.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class CarDriverNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1758522803552618403L;
	
	private static String messageKey = "exception.carDriverNotFoundException";
    private Locale locale;
    
    public CarDriverNotFoundException() {
        this(messageKey, Locale.getDefault());
    }

    public CarDriverNotFoundException(String messageKey, Locale locale) {
    	CarDriverNotFoundException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
