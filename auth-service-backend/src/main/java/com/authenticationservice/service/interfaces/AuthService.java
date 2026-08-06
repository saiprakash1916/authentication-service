package com.authenticationservice.service.interfaces;

import com.authenticationservice.dto.request.RegisterRequest;
import com.authenticationservice.dto.response.ApiResponse;

public interface AuthService {

    ApiResponse register(RegisterRequest request);
}
