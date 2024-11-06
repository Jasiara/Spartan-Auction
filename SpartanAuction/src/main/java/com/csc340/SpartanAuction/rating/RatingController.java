package com.csc340.SpartanAuction.rating;

import com.csc340.SpartanAuction.review.Review;
import com.csc340.SpartanAuction.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("/all")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getAllRatingsForOneUser(@PathVariable int userId) {
        return ratingService.getAllRatingsForOneUser(userId);
    }

    @GetMapping("/{id}")
    public Rating getOneRating(@PathVariable int id) {
        return ratingService.getRatingById(id);
    }


    @PostMapping("/new")
    public List<Rating> addNewRating(@RequestBody Rating rating) {
        //System.out.println(rating.toString());
        ratingService.addNewRating(rating);
        return ratingService.getAllRatings();
    }

    @PutMapping("/update/{id}")
    public Rating updateRating(@PathVariable int id, @RequestBody Rating rating) {
        ratingService.updateRating(id, rating);
        return ratingService.getRatingById(id);
    }


    @DeleteMapping("/delete/{id}")
    public List<Rating> deleteRatingById(@PathVariable int id) {
        ratingService.deleteRatingById(id);
        return ratingService.getAllRatings();
    }
}
