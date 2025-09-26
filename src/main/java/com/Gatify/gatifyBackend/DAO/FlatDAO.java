package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Flat;

import java.util.List;

public interface FlatDAO {
    List<Flat> findAll();
    Flat findById(int flatId);
    Flat save(Flat flat);
    void deleteById(int flatId);
}