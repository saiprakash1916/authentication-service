package com.authenticationservice.service.interfaces;

import com.authenticationservice.dto.request.LoginRequest;
import com.authenticationservice.dto.request.RegisterRequest;
import com.authenticationservice.dto.response.ApiResponse;
import com.authenticationservice.dto.response.LoginResponse;

public interface AuthService {

    ApiResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
