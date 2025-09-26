package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Complaint;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplaintDAOJpaImpl implements ComplaintDAO {

    private EntityManager entityManager;

    @Autowired
    public ComplaintDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Complaint> findAll() {
        TypedQuery<Complaint> query = entityManager.createQuery("FROM Complaint", Complaint.class);
        return query.getResultList();
    }

    @Override
    public Complaint findById(int id) {
        return entityManager.find(Complaint.class, id);
    }

    @Override
    public Complaint save(Complaint complaint) {
        // For new complaint, ensure status is Pending
        if(complaint.getId() == 0) {
            complaint.setComplaintStatus(Complaint.ComplaintStatus.Pending);
            entityManager.persist(complaint);
        } else {
            complaint = entityManager.merge(complaint);
        }
        return complaint;
    }

    @Override
    public void deleteById(int id) {
        Complaint complaint = entityManager.find(Complaint.class, id);
        if(complaint != null) {
            entityManager.remove(complaint);
        }
    }
}