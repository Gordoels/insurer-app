package com.insurer.app.cardriver.exception;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.insurer.app.messages.config.Messages;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarDriverNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1758522803552618403L;
	
	private static final String MESSAGE_KEY = "exception.carDriverNotFoundException";
    private Locale locale;
    
    public CarDriverNotFoundException() {
        this(Locale.getDefault());
    }

    public CarDriverNotFoundException(Locale locale) {
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
