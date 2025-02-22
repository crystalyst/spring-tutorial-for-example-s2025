package com.example.frameworkstudycrud.user.repository;

import com.example.frameworkstudycrud.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User findUserByUsernameAndEmail(String username, String email);

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
