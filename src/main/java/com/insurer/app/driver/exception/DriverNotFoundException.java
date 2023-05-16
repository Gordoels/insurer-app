package com.insurer.app.driver.exception;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.insurer.app.messages.config.Messages;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DriverNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1474902126550642581L;
	
	private static final String MESSAGE_KEY = "exception.driverNotFoundException";
    private Locale locale;
    
    public DriverNotFoundException() {
        this(Locale.getDefault());
    }

    public DriverNotFoundException(Locale locale) {
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
