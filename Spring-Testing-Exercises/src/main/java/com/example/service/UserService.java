package com.example.service;

import com.example.entity.AppUser;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

    public List<AppUser> findUsersByName(String name) {
        return userRepository.findByName(name);
    }
}
