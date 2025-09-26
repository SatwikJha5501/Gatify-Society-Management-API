package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.EntryApproval;
import com.Gatify.gatifyBackend.Service.EntryApprovalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entry-approvals")
public class EntryApprovalRestController {

    private final EntryApprovalService entryApprovalService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EntryApprovalRestController(EntryApprovalService service, ObjectMapper mapper) {
        entryApprovalService = service;
        objectMapper = mapper;
    }

    @GetMapping
    public List<EntryApproval> findAll() {
        return entryApprovalService.findAll();
    }

    @GetMapping("/{id}")
    public EntryApproval getEntryApproval(@PathVariable int id) {
        EntryApproval approval = entryApprovalService.findById(id);
        if (approval == null) {
            throw new RuntimeException("EntryApproval id not found - " + id);
        }
        return approval;
    }

    @PostMapping
    public EntryApproval addEntryApproval(@RequestBody EntryApproval entryApproval) {
        entryApproval.setId(0); // Force save new item
        return entryApprovalService.save(entryApproval);
    }

    @PutMapping
    public EntryApproval updateEntryApproval(@RequestBody EntryApproval entryApproval) {
        return entryApprovalService.save(entryApproval);
    }

    @PatchMapping("/{id}")
    public EntryApproval patchEntryApproval(@PathVariable int id,
                                            @RequestBody Map<String, Object> patchPayload) {
        EntryApproval approval = entryApprovalService.findById(id);
        if (approval == null) {
            throw new RuntimeException("EntryApproval id not found - " + id);
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("EntryApproval id not allowed in request body");
        }
        ObjectNode approvalNode = objectMapper.convertValue(approval, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        approvalNode.setAll(patchNode);
        return entryApprovalService.save(objectMapper.convertValue(approvalNode, EntryApproval.class));
    }

    @DeleteMapping("/{id}")
    public String deleteEntryApproval(@PathVariable int id) {
        EntryApproval approval = entryApprovalService.findById(id);
        if (approval == null) {
            throw new RuntimeException("EntryApproval id not found - " + id);
        }
        entryApprovalService.deleteById(id);
        return "Deleted EntryApproval id - " + id;
    }
}