package com.insurer.app.insurance.exception;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.insurer.app.messages.config.Messages;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
