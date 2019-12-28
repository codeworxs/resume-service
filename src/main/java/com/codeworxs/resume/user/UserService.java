package com.codeworxs.resume.user;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {
	
	/** The user repository. */
	/**
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDTO getUserById(Long userId) {
		return createUserDto(userRepository.getOne(userId));
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
	**/
}
