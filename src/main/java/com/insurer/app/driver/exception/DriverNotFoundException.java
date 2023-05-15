package com.insurer.app.driver.exception;

import java.util.Locale;

import com.insurer.app.messages.Messages;

public class DriverNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1474902126550642581L;
	
	private final String messageKey;
    private final Locale locale;
	
	public DriverNotFoundException(String messageKey) {
        this(messageKey, Locale.getDefault());
    }

    public DriverNotFoundException(String messageKey, Locale locale) {
        this.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
	
}
