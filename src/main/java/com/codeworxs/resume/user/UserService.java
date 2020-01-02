package com.codeworxs.resume.user;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeworxs.resume.exception.ResourceNotFoundException;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {
	
	/** The user repository. */

	@Autowired
	private UserRepository userRepository;

	public UserDTO getUserById(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return createUserDto(user);
	}

	private UserDTO createUserDto(User user) {
		UserDTO userDto = new UserDTO();
		try {
			BeanUtils.copyProperties(userDto, user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error(e);
		}
		
		return userDto;
	}
	
}
