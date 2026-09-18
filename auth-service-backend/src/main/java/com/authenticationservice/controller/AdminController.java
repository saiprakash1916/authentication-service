package com.authenticationservice.controller;

import com.authenticationservice.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse> dashboard(){
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Welcome to admin dashboard")
                        .data(null)
                        .build()
        );
    }
}
