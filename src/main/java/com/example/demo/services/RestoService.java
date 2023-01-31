package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Resto;
import com.example.demo.repositories.IRestoRepository;

public class RestoService {
    private final IRestoRepository restoRepository;

    public RestoService(IRestoRepository restoRepository) {
        this.restoRepository = restoRepository;
    }

    public Resto addResto(String name) {
        Resto resto = new Resto(name);
        return restoRepository.save(resto);
    }
    // public void addRating(int rating, Long restoId){
    //     restoRepository.addRating(rating, restoId);
    // }

    public List<Resto> getResto() {
        return restoRepository.findAll();
    }
    public String getRestoById(Long restoId){
        return restoRepository.getRestoById(restoId);
    }

}
