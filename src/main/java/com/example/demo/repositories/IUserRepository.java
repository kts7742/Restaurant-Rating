package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.User;

public interface IUserRepository {
    User save(User song);
    List<User> findAll();
    User findById(Long id);
}
