package com.insurer.app.driver.exception;

import java.util.Locale;

import com.insurer.app.messages.Messages;

public class DriverUnderAgeException extends RuntimeException {
	
	private static final long serialVersionUID = 3412088822449934217L;
	
	private final String messageKey;
    private final Locale locale;
    
    public DriverUnderAgeException(String messageKey) {
        this(messageKey, Locale.getDefault());
    }

    public DriverUnderAgeException(String messageKey, Locale locale) {
        this.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
