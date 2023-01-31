package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Resto;

public class RestoRepository implements IRestoRepository{
    private final Map<Long, Resto> restoMap;
    private final Map<Resto, Integer> ratingMap;
    private Long autoIncrement = 1L;
    private int totalRating = 0;

    public RestoRepository(){
        restoMap = new HashMap<Long, Resto>();
        ratingMap = new HashMap<>();
    }

    @Override
    public Resto save(Resto resto) {
        Resto r = new Resto(autoIncrement, resto.getName());
        // Store the newly created question object to HashMap.
        restoMap.put(autoIncrement,r);
        // Increment the variable which will be used when next question is saved.
        ++autoIncrement;
        return r;
    }

    @Override
    public List<Resto> findAll() {
        return restoMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Resto> findById(Long id) {
        return Optional.ofNullable(restoMap.get(id));
    }
    @Override
    public void addRating(int rating, Resto resto){
        // ratingMap.put(resto, ratingMap.get(resto)+rating);
        // ++totalRating;
        // Resto resto = restoMap.get(restoId);
        resto.setTotalRating(rating);
    }
    public String getRestoById(Long restoId){
        String message = "";
        Resto resto = restoMap.get(restoId);
        String name = resto.getName();
        Double average = (Double)(resto.getAverageRating()*1.0);
        message += "Restaurant [id="+restoId+", name="+name+", rating="+average+"]";
        return message;
    }
    
}
