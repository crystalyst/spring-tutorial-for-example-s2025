package com.example.frameworkstudycrud.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    @JsonProperty("userId")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;
}
