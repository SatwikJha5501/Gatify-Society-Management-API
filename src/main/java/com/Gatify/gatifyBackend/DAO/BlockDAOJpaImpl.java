package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Block;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BlockDAOJpaImpl implements BlockDAO {
    private EntityManager entityManager;

    @Autowired
    public BlockDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Block> findAll() {
        return entityManager.createQuery("FROM Block", Block.class).getResultList();
    }

    @Override
    public Block findById(int id) {
        return entityManager.find(Block.class, id);
    }

    @Override
    public Block save(Block block) {
        return entityManager.merge(block);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Block.class, id));
    }
}