package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.*;
import com.example.demo.repositories.IRestoRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.repositories.RestoRepository;

public class ReviewService {
    private final IReviewRepository reviewRepository;
    private final IRestoRepository restoRepository;
    private final IUserRepository userRepository;

    public ReviewService(IReviewRepository reviewRepository, IRestoRepository restoRepository, IUserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.restoRepository = restoRepository;
        this.userRepository = userRepository;
    }

    public Review addReview(int rating, Long userId, Long restoId) {
        User user = userRepository.findById(userId);
        Resto resto = restoRepository.findById(restoId).orElseThrow();
        restoRepository.addRating(rating, resto);
        Review review = new Review(rating, user, resto);
        return reviewRepository.save(review);
    }

    public List<Review> getReview() {
        return reviewRepository.findAll();
    }
    public String getReviewOrder(Long restoId, String order){
        return reviewRepository.getReviewOrder(restoId, order);
    }
    public String getReviewOrderBy(Long restoId, int low, int high, String order){
        return reviewRepository.getReviewOrderBy(restoId, low, high, order);
    }
}
