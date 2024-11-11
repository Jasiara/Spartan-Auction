package com.csc340.SpartanAuction.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM review WHERE provider_id = :userId", nativeQuery = true)
    public List<Review> getAllReviewsForOneUser(@Param("userId") int userId);

    @Query(value = "SELECT (CASE WHEN AVG(review.rating) != 0 then AVG(review.rating) else 0 END) FROM review WHERE provider_id = :userId;", nativeQuery = true)
    public double getAverageRatingForOneUser(@Param("userId") int userId);
}
