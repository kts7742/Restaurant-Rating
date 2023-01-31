package com.example.demo.entities;

import java.util.List;

public class Resto {
    private Long id;
    private String name;
    List<Review> reviews;
    Long totalRating = 0L;
    int noRating = 0;
    
    public Resto(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public Resto(String name){
        this(null, name);
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public List<Review> getReviews(){
        return reviews;
    }
    public Double getAverageRating(){
        return totalRating*1.0/noRating;
    }
    public void setTotalRating(int rating){
        totalRating += rating;
        noRating++;
    }
    public Long getTotalRating(){
        return totalRating;
    }
    @Override
    public String toString() {
        return "Restaurant [id=" + id + "]";
    }
}
