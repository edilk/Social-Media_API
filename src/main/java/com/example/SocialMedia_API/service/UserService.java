package com.example.SocialMedia_API.service;

import com.example.SocialMedia_API.dto.RegistrationDTO;
import com.example.SocialMedia_API.entity.User;
import com.example.SocialMedia_API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    Optional<User> findByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = findByUsernameOrEmail(usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with username or email " + usernameOrEmail + " not found"
                ));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
    }

    public User registerNewUser(RegistrationDTO registrationDTO) {

        String username = registrationDTO.getUsername();
        Optional<User> existingUsername = userRepository.findByUsername(username);
        if (existingUsername.isPresent()) {
            throw new IllegalArgumentException("User with username " + username + " exists");
        }

        String email = registrationDTO.getEmail();
        Optional<User> existingEmail = userRepository.findByEmail(email);
        if (existingEmail.isPresent()) {
            throw new IllegalArgumentException("User with email " + email + " exists");
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setRoles(List.of(roleService.getUserRole()));

        return userRepository.save(user);
    }
}
