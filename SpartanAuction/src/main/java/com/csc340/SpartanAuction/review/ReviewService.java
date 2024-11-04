package com.csc340.SpartanAuction.review;

import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public List<Review> getAllReviewsForOneUser(int userId) {
        return reviewRepository.getAllReviewsForOneUser(userId);
    }

    public void addNewReview(Review review) {
        reviewRepository.save(review);
    }

    public void updateReview(int id, Review review) {
        Review existing = getReviewById(id);
        existing.setReviewUser(review.getReviewUser());
        existing.setProviderUser(review.getProviderUser());
        existing.setReview(review.getReview());
        existing.setRating(review.getRating());

        //Technically the 4 lines above are not necessary because the save method merges by default.
        reviewRepository.save(existing);
    }


    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
}
