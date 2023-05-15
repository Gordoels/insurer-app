package com.insurer.app.insurance.exception;

import java.util.Locale;

import com.insurer.app.messages.Messages;

public class InsuranceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4049488316801178044L;

	private final String messageKey;
	private final Locale locale;

	public InsuranceNotFoundException(String messageKey) {
		this(messageKey, Locale.getDefault());
	}

	public InsuranceNotFoundException(String messageKey, Locale locale) {
		this.messageKey = messageKey;
		this.locale = locale;
	}

	public String getMessage() {
		return Messages.getMessageForLocale(messageKey, locale);
	}
}
