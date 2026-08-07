package com.authenticationservice.service.impl;

import com.authenticationservice.dto.request.LoginRequest;
import com.authenticationservice.dto.request.RegisterRequest;
import com.authenticationservice.dto.response.ApiResponse;
import com.authenticationservice.dto.response.LoginResponse;
import com.authenticationservice.entity.Role;
import com.authenticationservice.entity.User;
import com.authenticationservice.enums.RoleType;
import com.authenticationservice.exception.EmailAlreadyExistsException;
import com.authenticationservice.repository.RoleRepository;
import com.authenticationservice.repository.UserRepository;
import com.authenticationservice.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse register(RegisterRequest request) {

        //Check if email already exits or not
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exits");
        }

        // Get Default role
        Role role = roleRepository.findByName(RoleType.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Default Role not found"));

        // Create User

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .enabled(true)
                .roles(Set.of(role))
                .build();

        userRepository.save(user);

        return new ApiResponse("User registered Successful");
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
}
