package com.codeworxs.resume.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResumeNotFoundException extends NotFoundException{
	
	private static final long serialVersionUID = -2370667015618646047L;
	private static final String MESSAGE = "Resume not found";
	
	public ResumeNotFoundException() {
		super(MESSAGE);
	}

	public ResumeNotFoundException(Exception e) {
		super(e);
	}
	
}
