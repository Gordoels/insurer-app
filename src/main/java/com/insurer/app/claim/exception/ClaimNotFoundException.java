package com.insurer.app.claim.exception;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.insurer.app.messages.config.Messages;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClaimNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -3074858174772838364L;
	
	private static final String MESSAGE_KEY = "exception.claimNotFoundException";
    private Locale locale;
    
    public ClaimNotFoundException() {
        this(Locale.getDefault());
    }

    public ClaimNotFoundException( Locale locale) {
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
