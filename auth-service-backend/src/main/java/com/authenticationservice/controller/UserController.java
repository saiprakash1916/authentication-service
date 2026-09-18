package com.authenticationservice.controller;

import com.authenticationservice.dto.response.ApiResponse;
import com.authenticationservice.dto.response.UserProfileResponse;
import com.authenticationservice.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse> getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        UserProfileResponse userProfileResponse = userService.getCurrentUserProfile(email);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("User Profile retrieved successfully")
                        .data(userProfileResponse)
                        .build()
        );
    }
}
