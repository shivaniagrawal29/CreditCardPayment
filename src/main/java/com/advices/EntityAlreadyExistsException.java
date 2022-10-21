package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityAlreadyExistsException extends Exception {
	public EntityAlreadyExistsException(String message) {
		super(message);
	}
}
