package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.Complaint;
import java.util.List;

public interface ComplaintService {
    List<Complaint> findAll();
    Complaint findById(int id);
    Complaint save(Complaint complaint);
    void deleteById(int id);
}