package com.example.frameworkstudycrud.auth.service;

import com.example.frameworkstudycrud.user.dto.UserSignupRequest;
import com.example.frameworkstudycrud.user.model.User;
import com.example.frameworkstudycrud.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(UserSignupRequest userSignupRequest) {
        if (userRepository.findByEmail(userSignupRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        User newUser = User.builder()
                .email(userSignupRequest.getEmail())
                .username(userSignupRequest.getUsername())
                .password(passwordEncoder.encode(userSignupRequest.getPassword()))
                .build();

        userRepository.save(newUser);

        return newUser;
    }
}
