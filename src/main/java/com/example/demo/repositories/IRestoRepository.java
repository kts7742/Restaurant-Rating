package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Resto;

public interface IRestoRepository {
    Resto save(Resto song);
    List<Resto> findAll();
    Optional<Resto> findById(Long id);
    public void addRating(int rating, Resto resto);
    public String getRestoById(Long restoId);
}
