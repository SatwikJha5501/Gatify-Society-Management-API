package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.PreEntryApproval;
import com.Gatify.gatifyBackend.Service.PreEntryApprovalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pre-entries")
public class PreEntryApprovalRestController {

    private final PreEntryApprovalService preEntryService;
    private final ObjectMapper objectMapper;

    @Autowired
    public PreEntryApprovalRestController(PreEntryApprovalService preEntryService,
                                          ObjectMapper objectMapper) {
        this.preEntryService = preEntryService;
        this.objectMapper = objectMapper;
    }

    // Get all pre-entries
    @GetMapping
    public List<PreEntryApproval> findAll() {
        return preEntryService.findAll();
    }

    // Get single pre-entry by ID
    @GetMapping("/{preEntryId}")
    public PreEntryApproval getPreEntry(@PathVariable int preEntryId) {
        PreEntryApproval preEntry = preEntryService.findById(preEntryId);

        if (preEntry == null) {
            throw new RuntimeException("PreEntry id not found - " + preEntryId);
        }

        return preEntry;
    }

    // Add new pre-entry
    @PostMapping
    public PreEntryApproval addPreEntry(@RequestBody PreEntryApproval preEntry) {
        // Force save as new item
        preEntry.setId(0);
        return preEntryService.save(preEntry);
    }

    // Update existing pre-entry
    @PutMapping
    public PreEntryApproval updatePreEntry(@RequestBody PreEntryApproval preEntry) {
        return preEntryService.save(preEntry);
    }

    // Partial update
    @PatchMapping("/{preEntryId}")
    public PreEntryApproval patchPreEntry(@PathVariable int preEntryId,
                                          @RequestBody Map<String, Object> patchPayload) {

        PreEntryApproval tempPreEntry = preEntryService.findById(preEntryId);

        if (tempPreEntry == null) {
            throw new RuntimeException("PreEntry id not found - " + preEntryId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("PreEntry id not allowed in request body");
        }

        PreEntryApproval patchedPreEntry = applyPatch(patchPayload, tempPreEntry);
        return preEntryService.save(patchedPreEntry);
    }

    // Delete pre-entry
    @DeleteMapping("/{preEntryId}")
    public String deletePreEntry(@PathVariable int preEntryId) {
        PreEntryApproval tempPreEntry = preEntryService.findById(preEntryId);

        if (tempPreEntry == null) {
            throw new RuntimeException("PreEntry id not found - " + preEntryId);
        }

        preEntryService.deleteById(preEntryId);
        return "Deleted pre-entry id - " + preEntryId;
    }

    // Helper method for PATCH operation
    private PreEntryApproval applyPatch(Map<String, Object> patchPayload,
                                        PreEntryApproval tempPreEntry) {

        ObjectNode preEntryNode = objectMapper.convertValue(tempPreEntry, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        preEntryNode.setAll(patchNode);
        return objectMapper.convertValue(preEntryNode, PreEntryApproval.class);
    }
}