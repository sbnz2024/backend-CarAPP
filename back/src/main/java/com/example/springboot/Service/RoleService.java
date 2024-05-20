package com.example.springboot.Service;

import com.example.springboot.Repository.RoleRepository;
import com.example.springboot.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    public Role findRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }
}
