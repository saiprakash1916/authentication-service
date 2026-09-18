package com.authenticationservice.service.interfaces;

import com.authenticationservice.dto.response.UserProfileResponse;

public interface UserService {
    UserProfileResponse getCurrentUserProfile(String email);
}
