package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoRecordFoundException extends Exception {
	public NoRecordFoundException(String message) {
		super(message);
	}
}
