package com.insurer.app.driver.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class DriverUnderAgeException extends RuntimeException {
	
	private static final long serialVersionUID = 3412088822449934217L;
	
	private static final String MESSAGE_KEY = "exception.driverUnderAgeException";
    private Locale locale;
    
    public DriverUnderAgeException() {
        this(Locale.getDefault());
    }

    public DriverUnderAgeException(Locale locale) {
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(MESSAGE_KEY, locale);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
