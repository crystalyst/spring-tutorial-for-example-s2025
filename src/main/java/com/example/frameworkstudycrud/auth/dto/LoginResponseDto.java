package com.example.frameworkstudycrud.auth.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private String accessToken;
    private Long userId;
    private String username;
    private String email;
    private String role;
}
