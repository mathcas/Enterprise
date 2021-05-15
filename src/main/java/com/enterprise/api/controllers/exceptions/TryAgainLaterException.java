package com.enterprise.api.controllers.exceptions;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Try again later") 
public class TryAgainLaterException extends JSONException {

	private static final long serialVersionUID = 1405742882051664805L;

	public TryAgainLaterException(String message) {
		super(message);
	}
}
