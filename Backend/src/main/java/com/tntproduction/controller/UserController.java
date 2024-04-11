package com.tntproduction.controller;

import com.tntproduction.model.dto.ChangePasswordRequest;

import com.tntproduction.model.entity.User;
import com.tntproduction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

}
