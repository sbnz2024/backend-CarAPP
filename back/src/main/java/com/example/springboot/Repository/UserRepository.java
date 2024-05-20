package com.example.springboot.Repository;

import com.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserByEmailAndPassword(String email, String password);

}
