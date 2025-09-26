package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.EntryApprovalDAO;
import com.Gatify.gatifyBackend.Entity.EntryApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EntryApprovalServiceImpl implements EntryApprovalService {

    private final EntryApprovalDAO entryApprovalDAO;

    @Autowired
    public EntryApprovalServiceImpl(EntryApprovalDAO entryApprovalDAO) {
        this.entryApprovalDAO = entryApprovalDAO;
    }

    @Override
    public List<EntryApproval> findAll() {
        return entryApprovalDAO.findAll();
    }

    @Override
    public EntryApproval findById(int id) {
        return entryApprovalDAO.findById(id);
    }

    @Transactional
    @Override
    public EntryApproval save(EntryApproval entryApproval) {
        return entryApprovalDAO.save(entryApproval);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        entryApprovalDAO.deleteById(id);
    }
}