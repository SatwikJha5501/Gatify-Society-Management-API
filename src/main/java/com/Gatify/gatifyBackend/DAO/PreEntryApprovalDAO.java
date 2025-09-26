package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.PreEntryApproval;
import java.util.List;

public interface PreEntryApprovalDAO {
    List<PreEntryApproval> findAll();
    PreEntryApproval findById(int id);
    PreEntryApproval save(PreEntryApproval preEntry);
    void deleteById(int id);
}