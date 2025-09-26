package com.Gatify.gatifyBackend.Service;

import com.Gatify.gatifyBackend.DAO.FlatDAO;
import com.Gatify.gatifyBackend.Entity.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FlatServiceImpl implements FlatService {

    private FlatDAO flatDAO;

    @Autowired
    public FlatServiceImpl(FlatDAO flatDAO) {
        this.flatDAO = flatDAO;
    }

    @Override
    public List<Flat> findAll() {
        return flatDAO.findAll();
    }

    @Override
    public Flat findById(int flatId) {
        return flatDAO.findById(flatId);
    }

    @Transactional
    @Override
    public Flat save(Flat flat) {
        return flatDAO.save(flat);
    }

    @Transactional
    @Override
    public void deleteById(int flatId) {
        flatDAO.deleteById(flatId);
    }
}