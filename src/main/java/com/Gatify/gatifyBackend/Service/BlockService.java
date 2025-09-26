package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.Block;
import java.util.List;

public interface BlockService {
    List<Block> findAll();
    Block findById(int id);
    Block save(Block block);
    void deleteById(int id);
}