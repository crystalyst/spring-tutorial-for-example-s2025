package com.example.frameworkstudycrud.post.controller;

import com.example.frameworkstudycrud.post.model.Post;
import com.example.frameworkstudycrud.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public List<Post> getPosts() {
        return this.postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable("id") String postId) throws Exception {
        return this.postService.getPost(postId);
    }

    @PostMapping
    public void createPost(@RequestBody Map<String, String> payload) {
        String title = payload.get("title");
        String content  = payload.get("content");
        this.postService.createPost(title, content);
    }

    @PutMapping("/{id}")
    public Post modifyPost(@PathVariable("id") String postId, @RequestBody Map<String, String> payload) throws Exception {
        String title = null;
        String content = null;
        if (payload.get("title") != null && !payload.get("title").isBlank()) {
            title = payload.get("title");
        }
        if (payload.get("content") != null && !payload.get("content").isBlank()) {
            content = payload.get("content");
        }
        return this.postService.modifyPost(postId, title, content);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") String postId) throws Exception {
        this.postService.deletePost(postId);
    }
}
