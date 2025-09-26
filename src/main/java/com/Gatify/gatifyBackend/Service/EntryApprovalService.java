package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.EntryApproval;
import java.util.List;

public interface EntryApprovalService {
    List<EntryApproval> findAll();
    EntryApproval findById(int id);
    EntryApproval save(EntryApproval entryApproval);
    void deleteById(int id);
}