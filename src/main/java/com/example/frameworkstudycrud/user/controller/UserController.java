package com.example.frameworkstudycrud.user.controller;

import com.example.frameworkstudycrud.user.model.User;
import com.example.frameworkstudycrud.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

//    private final UserService userService;

//    @PostMapping("/register")
//    public User register(@RequestBody Map<String, String> payload) throws Exception {
//        String email = payload.get("email");
//        String username = payload.get("username");
//        String password = payload.get("password");
//
//        return this.userService.register(email, username, password);
//    }
//
//    @GetMapping("/{id}")
//    public User getUser(@PathVariable("id") String userId) throws Exception {
//        return this.userService.getUser(userId);
//    }
//
//    @GetMapping("/lists")
//    public List<User> getUsers() {
//        return this.userService.getUsers();
//    }
}
