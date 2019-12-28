package com.codeworxs.resume.app;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class ResumeMasterDto {

	private Long resumeId;
	private Long userId;
	private String resumeName;
	private Integer templateId;
	
	@JsonProperty("resumeJson")
    private JsonNode resumeJson;
	
	private LocalDateTime createdOnTime;
	private LocalDateTime lastAccessTime;
}
