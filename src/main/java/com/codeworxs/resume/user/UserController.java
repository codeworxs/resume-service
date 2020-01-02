package com.codeworxs.resume.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeworxs.resume.security.CurrentUser;
import com.codeworxs.resume.security.UserPrincipal;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserDTO getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userService.getUserById(userPrincipal.getId());
    }
}
