package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Notice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeDAOJpaImpl implements NoticeDAO {

    private final EntityManager entityManager;

    @Autowired
    public NoticeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Notice> findAll() {
        TypedQuery<Notice> query = entityManager.createQuery("FROM Notice", Notice.class);
        return query.getResultList();
    }

    @Override
    public Notice findById(int id) {
        return entityManager.find(Notice.class, id);
    }

    @Override
    public Notice save(Notice notice) {
        return entityManager.merge(notice);
    }

    @Override
    public void deleteById(int id) {
        Notice notice = entityManager.find(Notice.class, id);
        entityManager.remove(notice);
    }
}