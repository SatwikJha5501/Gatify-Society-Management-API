package com.Gatify.gatifyBackend.DAO;

import com.Gatify.gatifyBackend.Entity.Notice;
import java.util.List;

public interface NoticeDAO {
    List<Notice> findAll();
    Notice findById(int id);
    Notice save(Notice notice);
    void deleteById(int id);
}