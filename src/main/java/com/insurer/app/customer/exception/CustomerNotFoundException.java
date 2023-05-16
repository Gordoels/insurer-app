package com.insurer.app.customer.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5167359807360729419L;
	
	private static final String MESSAGE_KEY = "exception.customerNotFoundException";
	
    private Locale locale;
    
    public CustomerNotFoundException() {
        this(Locale.getDefault());
    }

    public CustomerNotFoundException(Locale locale) {
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
