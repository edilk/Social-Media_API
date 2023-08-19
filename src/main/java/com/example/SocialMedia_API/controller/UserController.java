package com.example.SocialMedia_API.controller;

import com.example.SocialMedia_API.dto.RegistrationDTO;
import com.example.SocialMedia_API.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationDTO registrationDTO) {
       try {
           return new ResponseEntity<>(userService.registerNewUser(registrationDTO), HttpStatus.OK);
       } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
