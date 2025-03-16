package com.example.frameworkstudycrud.post.service;

import com.example.frameworkstudycrud.post.model.Post;
import com.example.frameworkstudycrud.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post getPost(String postId) throws Exception {
        Optional<Post> post = this.postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("no such post exsits");

        }

        return post.get();
    }

    public List<Post> getPosts() {
        List<Post> postList = this.postRepository.findAll();
        return postList;
    }

    public void createPost(String title, String content) {
        Post post = new Post(UUID.randomUUID().toString(), title, content, LocalDateTime.now());
        this.postRepository.save(post);
    }

    public Post modifyPost(String postId, String title, String content) throws Exception {
        Optional<Post> post = this.postRepository.findById(postId);
        if (post.isPresent()) {
            Post targetPost = post.get();
            if (title != null) {
                targetPost.setTitle(title);
            }
            if (content != null) {
                targetPost.setContent(content);
            }
            this.postRepository.save(targetPost);
            return targetPost;
        }
        throw new Exception("no such post exists");
    }

    public void deletePost(String postId) throws Exception {
        Optional<Post> post = this.postRepository.findById(postId);
        if (post.isPresent()) {
            Post targetPost = post.get();
            this.postRepository.delete(targetPost);
            return;
        }
        throw new Exception("no such post exists");
    }
}
