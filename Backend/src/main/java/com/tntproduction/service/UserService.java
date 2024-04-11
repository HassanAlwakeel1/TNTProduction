package com.tntproduction.service;


import com.tntproduction.model.dto.ChangePasswordRequest;
import com.tntproduction.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

public interface UserService {
    UserDetailsService userDetailsService();
}
