package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.UserFlatRelation;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserFlatRelationDAOJpaImpl implements UserFlatRelationDAO {

    private EntityManager entityManager;

    @Autowired
    public UserFlatRelationDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserFlatRelation> findAll() {
        return entityManager.createQuery("FROM UserFlatRelation", UserFlatRelation.class).getResultList();
    }

    @Override
    public UserFlatRelation findById(Long id) {
        return entityManager.find(UserFlatRelation.class, id);
    }

    @Override
    public UserFlatRelation save(UserFlatRelation relation) {
        return entityManager.merge(relation);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(UserFlatRelation.class, id));
    }

    @Override
    public int findExistingCount(int flatId) {
        return entityManager.createQuery("Select count(*) as existing_count from society_db.user_flat_relation where flat_id = 3 and status = 'ACTIVE';").getFirstResult();
    }
}