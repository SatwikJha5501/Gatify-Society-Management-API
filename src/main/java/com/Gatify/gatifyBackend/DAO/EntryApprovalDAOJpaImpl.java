package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.EntryApproval;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EntryApprovalDAOJpaImpl implements EntryApprovalDAO {

    private EntityManager entityManager;

    @Autowired
    public EntryApprovalDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EntryApproval> findAll() {
        TypedQuery<EntryApproval> query = entityManager.createQuery("FROM EntryApproval", EntryApproval.class);
        return query.getResultList();
    }

    @Override
    public EntryApproval findById(int id) {
        return entityManager.find(EntryApproval.class, id);
    }

    @Override
    public EntryApproval save(EntryApproval entryApproval) {
        return entityManager.merge(entryApproval);
    }

    @Override
    public void deleteById(int id) {
        EntryApproval approval = entityManager.find(EntryApproval.class, id);
        entityManager.remove(approval);
    }
}