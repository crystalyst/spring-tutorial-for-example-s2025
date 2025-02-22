package com.example.frameworkstudycrud.auth.controller;

import com.example.frameworkstudycrud.auth.dto.LoginInResponseDto;
import com.example.frameworkstudycrud.auth.service.AuthService;
import com.example.frameworkstudycrud.user.dto.UserDto;
import com.example.frameworkstudycrud.user.dto.UserLoginRequest;
import com.example.frameworkstudycrud.user.dto.UserSignupRequest;
import com.example.frameworkstudycrud.user.model.User;
import com.example.frameworkstudycrud.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserSignupRequest userSignupRequest) {
        User registeredUser = authService.register(userSignupRequest);

        UserDto registeredUserResponse = UserDto.builder()
                .id(registeredUser.getId())
                .email(registeredUser.getEmail())
                .username(registeredUser.getUsername())
                .build();

        return ResponseEntity.ok(registeredUserResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInResponseDto> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest) {

    }

}
