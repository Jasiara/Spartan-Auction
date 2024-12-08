package com.csc340.SpartanAuction.reviewCompleted;


import com.csc340.SpartanAuction.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewCompletedService {
    @Autowired
    private ReviewCompletedRepository reviewCompletedRepository;

    public List<ReviewCompleted> getAllReviewsCompleted() {return reviewCompletedRepository.findAll();}

    public ReviewCompleted getReviewCompletedById(int id) {
        return reviewCompletedRepository.findById(id).orElse(null);
    }

    public ReviewCompleted getReviewCompletedForOneAuction(int auctionId) {
        return reviewCompletedRepository.getReviewCompletedByAuctionId(auctionId);
    }

    public ReviewCompleted getReviewCompletedForOneReview(int reviewId) {
        return reviewCompletedRepository.getReviewCompletedByReviewId(reviewId);
    }

    public List<ReviewCompleted> getAllReviewsCompletedForOneUser(int userId) {
        return reviewCompletedRepository.getAllReviewsCompletedForOneUser(userId);
    }

    public void addNewReviewCompleted(ReviewCompleted reviewCompleted) {
        if (reviewCompletedRepository.existsById(reviewCompleted.getId())) {
            reviewCompleted = new ReviewCompleted(reviewCompleted);
            reviewCompletedRepository.save(reviewCompleted);
            return;
        }
        reviewCompleted = new ReviewCompleted(reviewCompleted.getReview(), reviewCompleted.getAuction(),
                reviewCompleted.isReviewCompleted());
        reviewCompletedRepository.save(reviewCompleted);
    }

    public void updateReview(int id, ReviewCompleted reviewCompleted) {
        ReviewCompleted existing = getReviewCompletedById(id);
        existing.setReview(reviewCompleted.getReview());
        existing.setAuction(reviewCompleted.getAuction());
        existing.setReviewCompleted(reviewCompleted.isReviewCompleted());

        //Technically the 4 lines above are not necessary because the save method merges by default.
        reviewCompletedRepository.save(existing);
    }


    public void deleteReviewCompletedById(int id) {
        reviewCompletedRepository.deleteById(id);
    }
}
