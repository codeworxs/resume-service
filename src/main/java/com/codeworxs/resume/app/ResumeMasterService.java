package com.codeworxs.resume.app;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworxs.resume.exception.ResumeNotFoundException;
import com.codeworxs.resume.exception.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResumeMasterService {

	@Autowired
	private ResumeMasterRepository repository;
	
	public Long saveResume(ResumeMasterDto resumeDto) throws ServiceException {
		ResumeMaster resume = new ResumeMaster();
		try {
			BeanUtils.copyProperties(resume, resumeDto);
			resume.setData(new ObjectMapper().writeValueAsString(resumeDto.getResumeJson()));
			resume = repository.save(resume);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		return resume.getResumeId();
	}
	
	public ResumeMasterDto getResumeById(Long resumeId) throws ServiceException{
		ResumeMasterDto resumeDto = new ResumeMasterDto();
		ResumeMaster resume = repository.findById(resumeId).orElseThrow(ResumeNotFoundException::new);
		try {
			BeanUtils.copyProperties(resumeDto, resume);
			resumeDto.setResumeJson(new ObjectMapper().readTree(resume.getData()));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return resumeDto;
	}
}
