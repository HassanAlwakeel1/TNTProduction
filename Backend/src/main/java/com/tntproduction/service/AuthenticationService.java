package com.tntproduction.service;

import com.tntproduction.model.dto.JwtAuthenticationResponse;
import com.tntproduction.model.dto.RefreshTokenRequest;
import com.tntproduction.model.dto.SignInRequest;
import com.tntproduction.model.dto.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
