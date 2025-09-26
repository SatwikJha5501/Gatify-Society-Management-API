package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.PreEntryApproval;
import java.util.List;

public interface PreEntryApprovalService {
    List<PreEntryApproval> findAll();
    PreEntryApproval findById(int id);
    PreEntryApproval save(PreEntryApproval preEntry);
    void deleteById(int id);
}