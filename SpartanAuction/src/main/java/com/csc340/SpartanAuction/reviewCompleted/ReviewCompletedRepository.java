package com.csc340.SpartanAuction.reviewCompleted;

import com.csc340.SpartanAuction.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewCompletedRepository extends JpaRepository<ReviewCompleted, Integer> {
    @Query(value = "SELECT review_completed.id, review_completed.review_id, review_completed.auction_id, review_completed.review_completed" +
            " FROM review_completed, review" +
            " WHERE review.reviewer_id = :userId" +
            " AND review_completed.review_id = review.id", nativeQuery = true)
    public List<ReviewCompleted> getAllReviewsCompletedForOneUser(@Param("userId") int userId);

    @Query(value = "SELECT * FROM review_completed WHERE auction_id = :auctionId", nativeQuery = true)
    public ReviewCompleted getReviewCompletedByAuctionId(@Param("auctionId") int auctionId);

    @Query(value = "SELECT * FROM review_completed WHERE review_id = :reviewId", nativeQuery = true)
    public ReviewCompleted getReviewCompletedByReviewId(@Param("reviewId") int reviewId);

}
