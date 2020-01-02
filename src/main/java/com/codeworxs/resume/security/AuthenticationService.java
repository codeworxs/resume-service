package com.codeworxs.resume.security;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeworxs.resume.exception.BadRequestException;
import com.codeworxs.resume.payload.AuthResponse;
import com.codeworxs.resume.payload.LoginRequest;
import com.codeworxs.resume.payload.SignUpRequest;
import com.codeworxs.resume.user.AuthProvider;
import com.codeworxs.resume.user.User;
import com.codeworxs.resume.user.UserRepository;
import com.codeworxs.resume.user.UserType;

@Service
public class AuthenticationService {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;
    
    public AuthResponse authenticate(LoginRequest loginRequest) {
    	Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);
        return new AuthResponse(token);
    }
    
    public Long createUser(SignUpRequest signUpRequest) {
    	 if(Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
             throw new BadRequestException("Email address already in use.");
         }

         User user = new User();
         user.setName(signUpRequest.getName());
         user.setEmail(signUpRequest.getEmail());
         user.setPassword(signUpRequest.getPassword());
         user.setProvider(AuthProvider.LOCAL);
         user.setCreatedDateTime(LocalDateTime.now());
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setUserTypeId(UserType.STANDARD.getId());
         User result = userRepository.save(user);
         return result.getId();
    }
}
