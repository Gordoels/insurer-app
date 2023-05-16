package com.insurer.app.customer.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5167359807360729419L;
	
	private static String messageKey = "exception.custumerNotFoundException";
    private Locale locale;
    
    public CustomerNotFoundException() {
        this(messageKey, Locale.getDefault());
    }

    public CustomerNotFoundException(String messageKey, Locale locale) {
    	CustomerNotFoundException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }

}
