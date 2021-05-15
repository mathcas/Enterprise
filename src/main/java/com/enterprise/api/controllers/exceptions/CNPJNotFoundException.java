package com.enterprise.api.controllers.exceptions;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This CNPJ is invalid") 
public class CNPJNotFoundException extends JSONException {

	private static final long serialVersionUID = -6427381675203165066L;

	public CNPJNotFoundException(String message) {
		super(message);
	}
}
