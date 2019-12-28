package com.codeworxs.resume.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resume_master")
@Getter
@Setter
public class ResumeMaster {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;
	
	@Column(name = "user_id")
    private Long userId;
	
	@Column(name = "resume_name")
	private String resumeName;
	
	@Column(name = "template_id")
	private Integer templateId;
	
	@Column(name = "data")
	private String data;
	
	@Column(name = "created_on_time")
	private LocalDateTime createdOnTime;
	
	@Column(name = "last_accessed_time")
	private LocalDateTime lastAccessTime;

}
