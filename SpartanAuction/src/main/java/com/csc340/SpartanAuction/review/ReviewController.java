package com.csc340.SpartanAuction.review;

import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/user/{userId}")
    public List<Review> getAllReviewsForOneUser(@PathVariable int userId) {
        return reviewService.getAllReviewsForOneUser(userId);
    }

    @GetMapping("/{id}")
    public Review getOneReview(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }


    @PostMapping("/new")
    public List<Review> addNewReview(@RequestBody Review review) {
        reviewService.addNewReview(review);
        return reviewService.getAllReviews();
    }

    @PutMapping("/update/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
        return reviewService.getReviewById(id);
    }


    @DeleteMapping("/delete/{id}")
    public List<Review> deleteReviewById(@PathVariable int id) {
        reviewService.deleteReviewById(id);
        return reviewService.getAllReviews();
    }
}
