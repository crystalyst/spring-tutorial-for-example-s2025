package com.example.frameworkstudycrud.post.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "posts")
public class Post {
    @Id // <-- Define the primary key
    @JsonProperty("postId")
    private String postId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    @JsonProperty("createdDate")
    private LocalDateTime createdDate;
}
