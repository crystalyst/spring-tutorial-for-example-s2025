package com.example.frameworkstudycrud.user.service;

import com.example.frameworkstudycrud.user.model.User;
import com.example.frameworkstudycrud.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    public User register(String email, String username, String password) throws Exception {
//        if (userRepository.findUserByUsernameAndEmail(username, email) != null
//        || userRepository.findUserByUsername(username) != null
//        || userRepository.findUserByEmail(email) != null
//    ){
//            throw new Exception("user already exists");
//        }
//        User newUser = User.builder()
//                .userId(UUID.randomUUID().toString())
//                .username(username)
//                .email(email)
//                .password(password)
//                .build();
//        return newUser;
//    }
//
//    public User getUser(String userId) throws Exception {
//        Optional<User> targetUser = this.userRepository.findById(userId);
//        if (targetUser.isPresent()) {
//            return targetUser.get();
//        } else {
//            throw new Exception("no such user exists");
//        }
//    }
//
//    public List<User> getUsers() {
//        return this.userRepository.findAll();
//    }
}
