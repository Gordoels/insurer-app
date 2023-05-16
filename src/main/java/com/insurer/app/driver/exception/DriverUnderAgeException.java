package com.insurer.app.driver.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class DriverUnderAgeException extends RuntimeException {
	
	private static final long serialVersionUID = 3412088822449934217L;
	
	private static String messageKey = "exception.driverUnderAgeException";
    private Locale locale;
    
    public DriverUnderAgeException() {
        this(messageKey, Locale.getDefault());
    }

    public DriverUnderAgeException(String messageKey, Locale locale) {
        DriverUnderAgeException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
