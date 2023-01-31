package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.*;

public class ReviewRepository implements IReviewRepository{
    private final Map<Long, Review> reviewMap;
    private Long autoIncrement = 1L;

    public ReviewRepository(){
        reviewMap = new HashMap<>();
    }

    @Override
    public Review save(Review review) {
        Review r = new Review(autoIncrement, review.getRating(), review.getUser(), review.getResto());
        // Store the newly created question object to HashMap.
        reviewMap.put(autoIncrement,r);
        // Increment the variable which will be used when next question is saved.
        
        ++autoIncrement;
        return r;
    }

    @Override
    public List<Review> findAll() {
        return reviewMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Review findById(Long id) {
        return reviewMap.get(id);
    }

    public String getReviewOrder(Long restoId, String order){
        List<Review> all = reviewMap.values().stream().collect(Collectors.toList());
        List<Review> ans = new ArrayList<>();
        int idx = 0;
        while(idx < all.size()){
            if(all.get(idx).getResto().getId() == restoId){
                ans.add(all.get(idx));
            }
            idx++;
        }
        if(order.equals("RATING_DESC")){
            Collections.sort(ans, Collections.reverseOrder());
        }else{
            Collections.sort(ans);
        }
        String message = "[";
        idx = 0;
        while(idx < ans.size()){
            if(idx == ans.size()-1){
                message += "Review [id="+ans.get(idx).getId()+"]";
                break;
            }
            message += "Review [id="+ans.get(idx).getId()+"], ";
            idx++;
        }
        message += "]";
        return message;
    }
    public String getReviewOrderBy(Long restoId, int low, int high, String order){
        List<Review> all = reviewMap.values().stream().collect(Collectors.toList());
        List<Review> ans = new ArrayList<>();
        int idx = 0;
        while(idx < all.size()){
            if(all.get(idx).getResto().getId() == restoId && all.get(idx).getRating() >= low && 
            all.get(idx).getRating() <= high){
                ans.add(all.get(idx));
            }
            idx++;
        }
        if(order.equals("RATING_DESC")){
            Collections.sort(ans, Collections.reverseOrder());
        }else{
            Collections.sort(ans);
        }
        String message = "[";
        idx = 0;
        while(idx < ans.size()){
            if(idx == ans.size()-1){
                message += "Review [id="+ans.get(idx).getId()+"]";
                break;
            }
            message += "Review [id="+ans.get(idx).getId()+"], ";
            idx++;
        }
        message += "]";
        return message;
    }
    
}
