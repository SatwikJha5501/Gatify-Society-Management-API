package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.Society;
import com.Gatify.gatifyBackend.Service.SocietyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/societies")
public class SocietyRestController {
    private final SocietyService societyService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SocietyRestController(SocietyService societyService, ObjectMapper objectMapper) {
        this.societyService = societyService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Society> findAll() {
        return societyService.findAll();
    }

    @GetMapping("/{societyId}")
    public Society getSociety(@PathVariable int societyId) {
        Society society = societyService.findById(societyId);
        if (society == null) {
            throw new RuntimeException("Society id not found - " + societyId);
        }
        return society;
    }

    @PostMapping
    public Society addSociety(@RequestBody Society society) {
        society.setId(0);
        return societyService.save(society);
    }

    @PutMapping
    public Society updateSociety(@RequestBody Society society) {
        return societyService.save(society);
    }

    @PatchMapping("/{societyId}")
    public Society patchSociety(@PathVariable int societyId, @RequestBody Map<String, Object> patchPayload) {
        Society tempSociety = societyService.findById(societyId);
        if (tempSociety == null) {
            throw new RuntimeException("Society id not found - " + societyId);
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Society id not allowed in request body - " + societyId);
        }
        Society patchedSociety = apply(patchPayload, tempSociety);
        return societyService.save(patchedSociety);
    }

    @DeleteMapping("/{societyId}")
    public String deleteSociety(@PathVariable int societyId) {
        Society tempSociety = societyService.findById(societyId);
        if (tempSociety == null) {
            throw new RuntimeException("Society id not found - " + societyId);
        }
        societyService.deleteById(societyId);
        return "Deleted society id - " + societyId;
    }

    private Society apply(Map<String, Object> patchPayload, Society tempSociety) {
        ObjectNode societyNode = objectMapper.convertValue(tempSociety, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        societyNode.setAll(patchNode);
        return objectMapper.convertValue(societyNode, Society.class);
    }
}