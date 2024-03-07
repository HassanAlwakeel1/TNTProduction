package com.tntproduction.model.dto;


import com.tntproduction.model.entity.enums.Role;
import lombok.Data;

@Data
public class SignUpRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;
}

