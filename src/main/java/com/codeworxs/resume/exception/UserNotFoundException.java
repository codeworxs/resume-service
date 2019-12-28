package com.codeworxs.resume.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException{
	
	private static final long serialVersionUID = -2370667015618646047L;

	public UserNotFoundException() {
		super("User not found");
	}
	
}
