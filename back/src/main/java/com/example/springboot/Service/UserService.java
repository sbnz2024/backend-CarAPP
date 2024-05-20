package com.example.springboot.Service;

import com.example.springboot.DTO.JwtResponse;
import com.example.springboot.DTO.UserDTO;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.Util.TokenUtils;
import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;


    public User register(UserDTO userDTO) {
        var role = roleService.findRoleByName("ROLE_USER");
        System.out.println("Role: " + role.getName());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setRole(role);
        return userRepository.save(user);
    }

    public JwtResponse login(UserDTO userDTO) {
        System.out.println("User: "+ userDTO.getEmail() );
        System.out.println("Password: "+ userDTO.getPassword() );

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
//        var user = userRepository.findUserByEmail(userDTO.getEmail())
        var jwt = tokenUtils.generateToken(user.getUsername());
        return new JwtResponse(jwt, user.getRole().getName(), user.getId());
    }



}
