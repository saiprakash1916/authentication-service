package com.authenticationservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserProfileResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean enabled;
    private Set<String> roles;
}
