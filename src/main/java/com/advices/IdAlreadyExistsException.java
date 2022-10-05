package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdAlreadyExistsException extends Exception {
	public IdAlreadyExistsException(String message) {
		super(message);
	}
}
