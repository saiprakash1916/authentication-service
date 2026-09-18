package com.authenticationservice.config;

import com.authenticationservice.entity.Role;
import com.authenticationservice.enums.RoleType;
import com.authenticationservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;

    @Bean
    CommandLineRunner initializeRoles(){
        return args -> Arrays.stream(RoleType.values())
                .filter(roleType -> roleRepository.findByName(roleType).isEmpty())
                .forEach(roleType -> roleRepository.save(
                        Role.builder()
                                .name(roleType)
                                .build()
                ));
    }
}
