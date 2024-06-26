package com.ptit.Hirex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedEntityException extends RuntimeException {

	public DuplicatedEntityException(String message) {
        super(message);
    }
}