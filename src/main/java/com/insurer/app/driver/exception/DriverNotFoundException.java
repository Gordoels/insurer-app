package com.insurer.app.driver.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class DriverNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1474902126550642581L;
	
	private static String messageKey = "exception.driverNotFoundException";
    private Locale locale;
    
    public DriverNotFoundException() {
        this(messageKey, Locale.getDefault());
    }

    public DriverNotFoundException(String messageKey, Locale locale) {
    	DriverNotFoundException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
	
}
