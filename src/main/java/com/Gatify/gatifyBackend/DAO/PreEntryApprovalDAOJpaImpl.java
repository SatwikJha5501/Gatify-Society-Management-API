package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.DAO.PreEntryApprovalDAO;
import com.Gatify.gatifyBackend.Entity.PreEntryApproval;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PreEntryApprovalDAOJpaImpl implements PreEntryApprovalDAO {

    private final EntityManager entityManager;

    @Autowired
    public PreEntryApprovalDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PreEntryApproval> findAll() {
        TypedQuery<PreEntryApproval> query = entityManager.createQuery(
                "FROM PreEntryApproval", PreEntryApproval.class);
        return query.getResultList();
    }

    @Override
    public PreEntryApproval findById(int id) {
        return entityManager.find(PreEntryApproval.class, id);
    }

    @Override
    public PreEntryApproval save(PreEntryApproval preEntry) {
        return entityManager.merge(preEntry);
    }

    @Override
    public void deleteById(int id) {
        PreEntryApproval preEntry = entityManager.find(PreEntryApproval.class, id);
        if (preEntry != null) {
            entityManager.remove(preEntry);
        }
    }
}