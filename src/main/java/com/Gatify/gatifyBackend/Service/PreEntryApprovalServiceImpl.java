package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.PreEntryApproval;
import com.Gatify.gatifyBackend.DAO.PreEntryApprovalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PreEntryApprovalServiceImpl implements PreEntryApprovalService {

    private final PreEntryApprovalDAO preEntryDAO;

    @Autowired
    public PreEntryApprovalServiceImpl(PreEntryApprovalDAO preEntryDAO) {
        this.preEntryDAO = preEntryDAO;
    }

    @Override
    @Transactional
    public List<PreEntryApproval> findAll() {
        return preEntryDAO.findAll();
    }

    @Override
    @Transactional
    public PreEntryApproval findById(int id) {
        return preEntryDAO.findById(id);
    }

    @Override
    @Transactional
    public PreEntryApproval save(PreEntryApproval preEntry) {
        return preEntryDAO.save(preEntry);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        preEntryDAO.deleteById(id);
    }
}