package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}