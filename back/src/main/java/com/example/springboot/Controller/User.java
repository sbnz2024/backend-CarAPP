package com.example.springboot.Controller;

import com.example.springboot.DTO.JwtResponse;
import com.example.springboot.DTO.UserDTO;
import com.example.springboot.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "**")
@RequiredArgsConstructor
public class User {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "*", allowedHeaders = "**")
    @PostMapping("/register")
    public ResponseEntity<com.example.springboot.model.User> register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.register(userDTO));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "**")
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDTO userDTO) {
        // how to authenticate user here?
        System.out.println("UserDTO: " + userDTO);
        return ResponseEntity.ok(userService.login(userDTO));
    }
}
