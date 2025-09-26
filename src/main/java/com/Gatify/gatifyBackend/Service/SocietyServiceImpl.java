package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.SocietyDAO;
import com.Gatify.gatifyBackend.Entity.Society;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SocietyServiceImpl implements SocietyService {
    private final SocietyDAO societyDAO;

    @Autowired
    public SocietyServiceImpl(SocietyDAO societyDAO) {
        this.societyDAO = societyDAO;
    }

    @Override
    public List<Society> findAll() {
        return societyDAO.findAll();
    }

    @Override
    public Society findById(int id) {
        return societyDAO.findById(id);
    }

    @Override
    @Transactional
    public Society save(Society society) {
        return societyDAO.save(society);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        societyDAO.deleteById(id);
    }
}