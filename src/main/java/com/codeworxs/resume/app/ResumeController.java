package com.codeworxs.resume.app;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworxs.resume.exception.ServiceException;

@RestController
@RequestMapping("/api/v1/resume")
public class ResumeController {
	
	@Autowired
	private ResumeMasterService resumeMasterService;
	
	@GetMapping(value = "/{id}")
	public ResumeMasterDto getResumeById(@PathVariable Long id) throws ServiceException {
		return resumeMasterService.getResumeById(id);
	}

	@PostMapping
	public void createNewResume(@RequestBody ResumeMasterDto resumeMaster) throws ServiceException {
		resumeMaster.setCreatedOnTime(LocalDateTime.now());
		resumeMasterService.saveResume(resumeMaster);
	}
	
	@PutMapping
	public void updateResume(@RequestBody ResumeMasterDto resumeMaster) throws ServiceException {
		resumeMasterService.saveResume(resumeMaster);
	}
	
	
}
