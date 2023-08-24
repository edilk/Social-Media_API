package com.example.SocialMedia_API.service;

import com.example.SocialMedia_API.entity.Role;
import com.example.SocialMedia_API.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole() {
        Optional<Role> role = roleRepository.findByName("USER");
        Role admin = new Role();
        admin.setName("USER");
        return role.orElseGet(() -> roleRepository.save(admin));
    }
}
