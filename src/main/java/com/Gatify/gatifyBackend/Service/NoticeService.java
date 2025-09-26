package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.Entity.Notice;
import java.util.List;

public interface NoticeService {
    List<Notice> findAll();
    Notice findById(int id);
    Notice save(Notice notice);
    void deleteById(int id);
}