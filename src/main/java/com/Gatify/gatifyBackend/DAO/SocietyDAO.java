package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Society;
import java.util.List;

public interface SocietyDAO {
    List<Society> findAll();
    Society findById(int id);
    Society save(Society society);
    void deleteById(int id);
}