package com.authenticationservice.controller;

import com.authenticationservice.dto.request.LoginRequest;
import com.authenticationservice.dto.request.RegisterRequest;
import com.authenticationservice.dto.response.ApiResponse;
import com.authenticationservice.dto.response.LoginResponse;
import com.authenticationservice.service.interfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse register(@Valid @RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest request){
        LoginResponse loginResponse  =authService.login(request);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Login Successfully..")
                        .data(loginResponse)
                        .build()
        );
    }
}
