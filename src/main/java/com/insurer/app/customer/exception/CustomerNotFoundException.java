package com.insurer.app.customer.exception;

import java.util.Locale;

import com.insurer.app.messages.Messages;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5167359807360729419L;
	
	private final String messageKey;
    private final Locale locale;
	
	public CustomerNotFoundException(String messageKey) {
        this(messageKey, Locale.getDefault());
    }

    public CustomerNotFoundException(String messageKey, Locale locale) {
        this.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }

}
