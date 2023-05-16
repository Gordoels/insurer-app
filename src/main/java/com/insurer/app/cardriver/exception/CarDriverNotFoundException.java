package com.insurer.app.cardriver.exception;

import java.util.Locale;

import com.insurer.app.messages.Messages;

public class CarDriverNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1758522803552618403L;
	
	private final String messageKey;
    private final Locale locale;
	
	public CarDriverNotFoundException(String messageKey) {
        this(messageKey, Locale.getDefault());
    }

    public CarDriverNotFoundException(String messageKey, Locale locale) {
        this.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
