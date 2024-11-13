package com.csc340.SpartanAuction.rating;

import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(int id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public List<Rating> getAllRatingsForOneUser(int userId) {
        return ratingRepository.getAllRatingsForOneUser(userId);
    }

    public void addNewRating(Rating rating) {
        if (ratingRepository.existsById(rating.getId())) {
            rating = new Rating(rating);
            ratingRepository.save(rating);
            return;
        }
        rating = new Rating(rating.getUser(), rating.getRating());
        ratingRepository.save(rating);
    }

    public void updateRating(int id, Rating rating) {
        Rating existing = getRatingById(id);
        existing.setUser(rating.getUser());
        existing.setRating(rating.getRating());
        //Technically the 4 lines above are not necessary because the save method merges by default.
        ratingRepository.save(existing);
    }


    public void deleteRatingById(int id) {
        ratingRepository.deleteById(id);
    }
}
