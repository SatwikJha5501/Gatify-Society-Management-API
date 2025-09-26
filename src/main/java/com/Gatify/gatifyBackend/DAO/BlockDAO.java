package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Block;
import java.util.List;

public interface BlockDAO {
    List<Block> findAll();
    Block findById(int id);
    Block save(Block block);
    void deleteById(int id);
}