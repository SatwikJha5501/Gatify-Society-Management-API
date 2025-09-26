package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Flat;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FlatDAOJpaImpl implements FlatDAO {
    private EntityManager entityManager;

    @Autowired
    public FlatDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Flat> findAll() {
        return entityManager.createQuery("FROM Flat", Flat.class).getResultList();
    }

    @Override
    public Flat findById(int flatId) {
        return entityManager.find(Flat.class, flatId);
    }

    @Override
    public Flat save(Flat flat) {
        return entityManager.merge(flat);
    }

    @Override
    public void deleteById(int flatId) {
        Flat flat = entityManager.find(Flat.class, flatId);
        if (flat != null) {
            entityManager.remove(flat);
        }
    }
}
