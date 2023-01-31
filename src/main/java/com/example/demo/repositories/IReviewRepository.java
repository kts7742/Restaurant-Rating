package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Review;

public interface IReviewRepository {
    Review save(Review song);
    List<Review> findAll();
    Review findById(Long id);
    public String getReviewOrder(Long restoId, String order);
    public String getReviewOrderBy(Long restoId, int low, int high, String order);
}
