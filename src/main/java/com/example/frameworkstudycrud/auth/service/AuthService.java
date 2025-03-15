package com.example.frameworkstudycrud.auth.service;

import com.example.frameworkstudycrud.auth.dto.LoginResponseDto;
import com.example.frameworkstudycrud.security.JwtUtil;
import com.example.frameworkstudycrud.user.dto.UserLoginRequest;
import com.example.frameworkstudycrud.user.dto.UserSignupRequest;
import com.example.frameworkstudycrud.user.model.User;
import com.example.frameworkstudycrud.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public User register(UserSignupRequest userSignupRequest) {
        if (userRepository.findByEmail(userSignupRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        System.out.println("raw " + userSignupRequest.getPassword());
        System.out.println("encoded: " + passwordEncoder.encode(userSignupRequest.getPassword()));
        System.out.println(passwordEncoder.matches(userSignupRequest.getPassword(), passwordEncoder.encode(userSignupRequest.getPassword())));

        User newUser = User.builder()
                .email(userSignupRequest.getEmail())
                .username(userSignupRequest.getUsername())
                .password(passwordEncoder.encode(userSignupRequest.getPassword()))
                .build();

        userRepository.save(newUser);

        return newUser;
    }

    public LoginResponseDto login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("No such user exists"));

        System.out.println(passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword()));

        if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Password does not match");
        }

        return LoginResponseDto.builder()
                .accessToken(jwtUtil.generateToken(user.getUsername()))
                .userId(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .role(String.valueOf(user.getRole()))
                .build();
    }
}
