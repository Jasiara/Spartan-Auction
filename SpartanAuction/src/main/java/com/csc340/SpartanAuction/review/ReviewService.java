package com.csc340.SpartanAuction.review;


import com.csc340.SpartanAuction.reply.Reply;
import com.csc340.SpartanAuction.reply.ReplyRepository;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompleted;
import com.csc340.SpartanAuction.reviewCompleted.ReviewCompletedRepository;
import com.csc340.SpartanAuction.user.User;
import com.csc340.SpartanAuction.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReviewCompletedRepository reviewCompletedRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
                Review theReview = reviewRepository.findById(id).orElse(null);
                return theReview;
    }

    public List<Review> getAllReviewsForOneUser(int userId) {
        return reviewRepository.getAllReviewsForOneUser(userId);
    }

    public void addNewReview(Review review, int auctionId) {
        if (reviewRepository.existsById(review.getId())) {
            review = new Review(review);
            reviewRepository.save(review);
            return;
        }
        review = new Review(review.getReviewUser(), review.getProviderUser(), review.getComment(), review.getRating());
        reviewRepository.save(review);

        ReviewCompleted reviewCompleted = reviewCompletedRepository.getReviewCompletedByAuctionId(auctionId);
        reviewCompleted.setReview(review);
        reviewCompleted.setReviewCompleted(true);
        reviewCompletedRepository.save(reviewCompleted);
    }

    public void updateReview(int id, Review review) {
        Review existing = getReviewById(id);
        existing.setReviewUser(review.getReviewUser());
        existing.setProviderUser(review.getProviderUser());
        existing.setComment(review.getComment());
        existing.setRating(review.getRating());

        //Technically the 4 lines above are not necessary because the save method merges by default.
        reviewRepository.save(existing);
    }


    public void deleteReviewById(int id) {
        List<Reply> allRepliesForOneReview = replyRepository.getAllRepliesForOneReview(id);

        while (!allRepliesForOneReview.isEmpty()) {
            Reply deletedReply = allRepliesForOneReview.get(0);
            allRepliesForOneReview.remove(0);
            replyRepository.deleteById(deletedReply.getId());
        }

        ReviewCompleted reviewCompleted = reviewCompletedRepository.getReviewCompletedByReviewId(id);
        if (reviewCompleted != null) {
            reviewCompleted.setReviewCompleted(false);
            reviewCompleted.setReview(null);
            reviewCompletedRepository.save(reviewCompleted);
        }

        reviewRepository.deleteById(id);
    }
}
