package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.EntryApproval;
import java.util.List;

public interface EntryApprovalDAO {
    List<EntryApproval> findAll();
    EntryApproval findById(int id);
    EntryApproval save(EntryApproval entryApproval);
    void deleteById(int id);
}