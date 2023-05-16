package com.insurer.app.insurance.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class InsuranceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4049488316801178044L;

	private static final String MESSAGE_KEY = "exception.insuranceNotFoundException";
    private Locale locale;
    
    public InsuranceNotFoundException() {
        this(Locale.getDefault());
    }

    public InsuranceNotFoundException(Locale locale) {
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
