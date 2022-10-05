package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends Exception {
	public NoRecordFoundException(String message) {
		super(message);
	}
}
