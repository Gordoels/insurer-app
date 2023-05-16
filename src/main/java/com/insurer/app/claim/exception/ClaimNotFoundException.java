package com.insurer.app.claim.exception;

import java.util.Locale;

import com.insurer.app.messages.config.Messages;

public class ClaimNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -3074858174772838364L;
	
	private static String messageKey = "exception.claimNotFoundException";
    private Locale locale;
    
    public ClaimNotFoundException() {
        this(messageKey, Locale.getDefault());
    }

    public ClaimNotFoundException(String messageKey, Locale locale) {
    	ClaimNotFoundException.messageKey = messageKey;
        this.locale = locale;
    }

    public String getMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
	
}
