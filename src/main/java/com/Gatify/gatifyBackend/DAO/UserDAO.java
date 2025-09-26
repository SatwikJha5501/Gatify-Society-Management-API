package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.User;
import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}