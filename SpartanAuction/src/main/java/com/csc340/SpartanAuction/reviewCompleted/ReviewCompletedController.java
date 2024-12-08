package com.csc340.SpartanAuction.reviewCompleted;

import com.csc340.SpartanAuction.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews-completed")
public class ReviewCompletedController {

    @Autowired
    private ReviewCompletedService reviewCompletedService;

    @GetMapping("/all")
    public List<ReviewCompleted> getAllReviewsCompleted() {
        return reviewCompletedService.getAllReviewsCompleted();
    }

    @GetMapping("/user/{userId}")
    public List<ReviewCompleted> getAllReviewsCompletedForOneUser(@PathVariable int userId) {
        return reviewCompletedService.getAllReviewsCompletedForOneUser(userId);
    }

    @GetMapping("/auction/{auctionId}")
    public ReviewCompleted getReviewCompletedForOneAuction(@PathVariable int auctionId) {
        return reviewCompletedService.getReviewCompletedForOneAuction(auctionId);
    }

    @GetMapping("/review/{reviewId}")
    public ReviewCompleted getReviewCompletedForOneReview(@PathVariable int reviewId) {
        return reviewCompletedService.getReviewCompletedForOneReview(reviewId);
    }

    @GetMapping("/{id}")
    public ReviewCompleted getOneReviewCompleted(@PathVariable int id) {
        return reviewCompletedService.getReviewCompletedById(id);
    }


    @PostMapping("/new")
    public List<ReviewCompleted> addNewReviewCompleted(@RequestBody ReviewCompleted reviewCompleted) {
        //System.out.println(review.toString());
        reviewCompletedService.addNewReviewCompleted(reviewCompleted);
        return reviewCompletedService.getAllReviewsCompleted();
    }

    @PutMapping("/update/{id}")
    public ReviewCompleted updateReviewCompleted(@PathVariable int id, @RequestBody ReviewCompleted reviewCompleted) {
        reviewCompletedService.updateReview(id, reviewCompleted);
        return reviewCompletedService.getReviewCompletedById(id);
    }


    @DeleteMapping("/delete/{id}")
    public List<ReviewCompleted> deleteReviewCompletedById(@PathVariable int id) {
        reviewCompletedService.deleteReviewCompletedById(id);
        return reviewCompletedService.getAllReviewsCompleted();
    }
}
