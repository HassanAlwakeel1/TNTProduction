package com.tntproduction.service;


import com.tntproduction.model.dto.ChangePasswordRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

public interface UserService {
    UserDetailsService userDetailsService();

    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
