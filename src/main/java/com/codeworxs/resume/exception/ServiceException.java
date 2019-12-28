package com.codeworxs.resume.exception;

public class ServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException() {
		super("Unspecified exception");
	}
	
	public ServiceException(String message) {
		super(message);
	}
}
