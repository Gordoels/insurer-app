package com.insurer.app.insurance.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class InsuranceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4049488316801178044L;

	private static String messageKey = "exception.insuranceNotFoundException";
    private Locale locale;
    
    public InsuranceNotFoundException() {
        this(messageKey, Locale.getDefault());
    }

    public InsuranceNotFoundException(String messageKey, Locale locale) {
    	InsuranceNotFoundException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
