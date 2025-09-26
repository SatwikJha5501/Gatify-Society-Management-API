package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.Society;
import java.util.List;

public interface SocietyService {
    List<Society> findAll();
    Society findById(int id);
    Society save(Society society);
    void deleteById(int id);
}