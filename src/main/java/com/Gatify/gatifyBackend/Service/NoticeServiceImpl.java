package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.NoticeDAO;
import com.Gatify.gatifyBackend.Entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDAO noticeDAO;

    @Autowired
    public NoticeServiceImpl(NoticeDAO noticeDAO) {
        this.noticeDAO = noticeDAO;
    }

    @Override
    public List<Notice> findAll() {
        return noticeDAO.findAll();
    }

    @Override
    public Notice findById(int id) {
        return noticeDAO.findById(id);
    }

    @Transactional
    @Override
    public Notice save(Notice notice) {
        return noticeDAO.save(notice);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        noticeDAO.deleteById(id);
    }
}