package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.UserFlatRelation;
import java.util.List;

public interface UserFlatRelationService {
    List<UserFlatRelation> findAll();
    UserFlatRelation findById(Long id);
    UserFlatRelation save(UserFlatRelation relation);
    void deleteById(Long id);
}