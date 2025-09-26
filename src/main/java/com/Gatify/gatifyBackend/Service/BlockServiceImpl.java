package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.BlockDAO;
import com.Gatify.gatifyBackend.Entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    private final BlockDAO blockDAO;

    @Autowired
    public BlockServiceImpl(BlockDAO blockDAO) {
        this.blockDAO = blockDAO;
    }

    @Override
    public List<Block> findAll() {
        return blockDAO.findAll();
    }

    @Override
    public Block findById(int id) {
        return blockDAO.findById(id);
    }

    @Override
    @Transactional
    public Block save(Block block) {
        return blockDAO.save(block);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        blockDAO.deleteById(id);
    }
}