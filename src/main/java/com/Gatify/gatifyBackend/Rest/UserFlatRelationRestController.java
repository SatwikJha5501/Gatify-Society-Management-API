package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.UserFlatRelation;
import com.Gatify.gatifyBackend.Service.UserFlatRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-flat-relations")
public class UserFlatRelationRestController {

    private final UserFlatRelationService relationService;

    @Autowired
    public UserFlatRelationRestController(UserFlatRelationService relationService) {
        this.relationService = relationService;
    }

    @GetMapping
    public List<UserFlatRelation> findAll() {
        return relationService.findAll();
    }

    @GetMapping("/{id}")
    public UserFlatRelation findById(@PathVariable Long id) {
        return relationService.findById(id);
    }

    @PostMapping
    public UserFlatRelation addRelation(@RequestBody UserFlatRelation relation) {
        // Ensure status is set to PENDING regardless of input
        relation.setStatus(UserFlatRelation.Status.PENDING);
        return relationService.save(relation);
    }

    @PutMapping
    public UserFlatRelation updateRelation(@RequestBody UserFlatRelation relation) {
        return relationService.save(relation);
    }

    @DeleteMapping("/{id}")
    public String deleteRelation(@PathVariable Long id) {
        relationService.deleteById(id);
        return "Deleted relation with id: " + id;
    }
}