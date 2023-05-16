package com.insurer.app.car.exception;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.insurer.app.messages.config.Messages;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1379716571048609958L;
	
	private static final String MESSAGE_KEY = "exception.carNotFoundException";
	
    private Locale locale;
    
    public CarNotFoundException() {
        this(Locale.getDefault());
    }

    public CarNotFoundException(Locale locale) {
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
