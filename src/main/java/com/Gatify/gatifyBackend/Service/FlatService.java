    package com.Gatify.gatifyBackend.Service;

    import com.Gatify.gatifyBackend.Entity.Flat;
    import java.util.List;

    public interface FlatService {
        List<Flat> findAll();
        Flat findById(int flatId);
        Flat save(Flat flat);
        void deleteById(int flatId);
    }