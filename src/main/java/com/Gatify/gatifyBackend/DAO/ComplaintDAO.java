package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Complaint;
import java.util.List;

public interface ComplaintDAO {
    List<Complaint> findAll();
    Complaint findById(int id);
    Complaint save(Complaint complaint);
    void deleteById(int id);
}