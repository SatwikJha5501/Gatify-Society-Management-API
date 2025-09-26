package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.UserFlatRelationDAO;
import com.Gatify.gatifyBackend.Entity.UserFlatRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserFlatRelationServiceImpl implements UserFlatRelationService {

    private final UserFlatRelationDAO relationDAO;

    @Autowired
    public UserFlatRelationServiceImpl(UserFlatRelationDAO relationDAO) {
        this.relationDAO = relationDAO;
    }

    @Override
    public List<UserFlatRelation> findAll() {
        return relationDAO.findAll();
    }

    @Override
    public UserFlatRelation findById(Long id) {
        return relationDAO.findById(id);
    }

    @Transactional
    @Override
    public UserFlatRelation save(UserFlatRelation relation) {
        return relationDAO.save(relation);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        relationDAO.deleteById(id);
    }
}