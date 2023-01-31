package com.example.demo.entities;

import java.util.List;

public class User {
    private Long id;
    private String name;
    List<Review> reviews;
    
    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public User(String name){
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
    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }

}
