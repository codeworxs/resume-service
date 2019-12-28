package com.codeworxs.resume.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -2370667015618646047L;
	private static final String MESSAGE = "Resume not found";
	
	public NotFoundException(String message) {
		super(StringUtils.isEmpty(message) ? MESSAGE : message);
	}

	public NotFoundException(Exception e) {
		super(e.getMessage(), e);
	}
	
}
