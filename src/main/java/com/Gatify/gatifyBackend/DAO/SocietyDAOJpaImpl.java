package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Society;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SocietyDAOJpaImpl implements SocietyDAO {
    private EntityManager entityManager;

    @Autowired
    public SocietyDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Society> findAll() {
        return entityManager.createQuery("FROM Society", Society.class).getResultList();
    }

    @Override
    public Society findById(int id) {
        return entityManager.find(Society.class, id);
    }

    @Override
    public Society save(Society society) {
        return entityManager.merge(society);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Society.class, id));
    }
}