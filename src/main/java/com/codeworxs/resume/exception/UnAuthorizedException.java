package com.codeworxs.resume.exception;

import org.apache.commons.lang3.StringUtils;

public class UnAuthorizedException extends RuntimeException{
	
	private static final long serialVersionUID = -2370667015618646047L;
	private static final String MESSAGE = "Unauthorized";
	
	public UnAuthorizedException(String message) {
		super(StringUtils.isEmpty(message) ? MESSAGE : message);
	}

	public UnAuthorizedException(Exception e) {
		super(e.getMessage(), e);
	}
	
}