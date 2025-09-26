package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.ComplaintDAO;
import com.Gatify.gatifyBackend.Entity.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintDAO complaintDAO;

    @Autowired
    public ComplaintServiceImpl(ComplaintDAO complaintDAO) {
        this.complaintDAO = complaintDAO;
    }

    @Override
    @Transactional
    public List<Complaint> findAll() {
        return complaintDAO.findAll();
    }

    @Override
    @Transactional
    public Complaint findById(int id) {
        return complaintDAO.findById(id);
    }

    @Override
    @Transactional
    public Complaint save(Complaint complaint) {
        return complaintDAO.save(complaint);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        complaintDAO.deleteById(id);
    }
}