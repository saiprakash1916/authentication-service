package com.authenticationservice.config;

import com.authenticationservice.entity.Role;
import com.authenticationservice.enums.RoleType;
import com.authenticationservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        for (RoleType roleType : RoleType.values()){
            if (!roleRepository.existsByName(roleType)){
                Role role = Role.builder()
                        .name(roleType)
                        .build();

                roleRepository.save(role);
            }
        }
    }
}
