package com.example.demo.entities;

import java.util.List;

public class Review implements Comparable<Review>{
    Long id;
    int rating;
    List<Review> reviews;
    String description;
    String dishes;
    User user;
    Resto resto;

    public Review(Long id, int rating, User userId, Resto restoId){
        this.id = id;
        this.rating = rating;
        this.user = userId;
        this.resto = restoId;
    }
    public Review(int rating, User userId, Resto restoId){
        this(null, rating, userId, restoId);
    }
    public Long getId(){
        return id;
    }
    public int getRating(){
        return rating;
    }
    public List<Review> getReviews(){
        return reviews;
    }
    public String getDescription(){
        return description;
    }
    public String getDishes(){
        return dishes;
    }
    public User getUser(){
        return user;
    }
    public Resto getResto(){
        return resto;
    }
    @Override
    public String toString() {
        return "Review [id=" + id + "]" + " added successfully for "+getResto()+" by "+getUser()+"!";
    }
    @Override
    public int compareTo(Review o) {
        return this.rating - o.rating;
    }
}
