package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name) {
        User user = new User(name);
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
