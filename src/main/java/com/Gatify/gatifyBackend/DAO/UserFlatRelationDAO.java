package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.UserFlatRelation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFlatRelationDAO {
    List<UserFlatRelation> findAll();
    UserFlatRelation findById(Long id);
    UserFlatRelation save(UserFlatRelation relation);
    void deleteById(Long id);
    int findExistingCount(int flatId);
}