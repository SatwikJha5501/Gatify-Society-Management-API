package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.Complaint;
import com.Gatify.gatifyBackend.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintRestController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintRestController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping
    public List<Complaint> findAll() {
        return complaintService.findAll();
    }

    @GetMapping("/{id}")
    public Complaint getComplaint(@PathVariable int id) {
        Complaint complaint = complaintService.findById(id);
        if (complaint == null) {
            throw new RuntimeException("Complaint id not found - " + id);
        }
        return complaint;
    }

    @PostMapping
    public Complaint addComplaint(@RequestBody Complaint complaint) {
        // Ensure ID is set to 0 to force new creation
        complaint.setId(0);

        // Validate assigned fields for new complaint
        if(complaint.getComplaintStatus() != Complaint.ComplaintStatus.Pending) {
            throw new RuntimeException("New complaints must have Pending status");
        }

        return complaintService.save(complaint);
    }

    @PutMapping
    public Complaint updateComplaint(@RequestBody Complaint complaint) {
        return complaintService.save(complaint);
    }

    @DeleteMapping("/{id}")
    public String deleteComplaint(@PathVariable int id) {
        Complaint complaint = complaintService.findById(id);
        if (complaint == null) {
            throw new RuntimeException("Complaint id not found - " + id);
        }
        complaintService.deleteById(id);
        return "Deleted complaint id - " + id;
    }
}