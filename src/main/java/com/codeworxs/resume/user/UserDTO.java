package com.codeworxs.resume.user;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Timestamp createdDateTime;
	private byte isActive;
	private byte userType;
	
}
