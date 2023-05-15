package com.insurer.app.car.exception;

import java.util.Locale;

import com.insurer.app.messages.Messages;

public class CarNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1379716571048609958L;
	
	private final String messageKey;
    private final Locale locale;
	
	public CarNotFoundException(String messageKey) {
        this(messageKey, Locale.getDefault());
    }

    public CarNotFoundException(String messageKey, Locale locale) {
        this.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
	
}
