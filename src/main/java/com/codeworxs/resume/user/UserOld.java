package com.codeworxs.resume.user;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserOld implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue
	private Long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	private String password;
	
	@Column(name = "created_date_time")
	private Timestamp createdDateTime;

	@Column(name = "is_active")
	private byte isActive;

	@Column(name = "is_verified")
	private byte userType;
	
}
