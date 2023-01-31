package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository {
    private final Map<Long, User> userMap;
    private Long autoIncrement = 1L;

    public UserRepository(){
        userMap = new HashMap<>();
    }
    @Override
    public User save(User user) {
        // Create a new Question object with all the parameters with an unique ID.
        User u = new User(autoIncrement, user.getName());
        // Store the newly created question object to HashMap.
        userMap.put(autoIncrement,u);
        // Increment the variable which will be used when next question is saved.
        ++autoIncrement;
        return u;
    }
    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }
    @Override
    public User findById(Long id) {
        return userMap.get(id);
    }
}
