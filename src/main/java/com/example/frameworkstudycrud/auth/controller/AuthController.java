package com.example.frameworkstudycrud.auth.controller;

import com.example.frameworkstudycrud.auth.dto.LoginResponseDto;
import com.example.frameworkstudycrud.auth.service.AuthService;
import com.example.frameworkstudycrud.user.dto.UserDto;
import com.example.frameworkstudycrud.user.dto.UserLoginRequest;
import com.example.frameworkstudycrud.user.dto.UserSignupRequest;
import com.example.frameworkstudycrud.user.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        return ResponseEntity.ok(authService.login(userLoginRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok("User currently logged in: " + username);
    }


}
