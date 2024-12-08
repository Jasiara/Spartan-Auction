package com.csc340.SpartanAuction.reply;

import com.csc340.SpartanAuction.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    @Query(value = "SELECT * FROM reply WHERE review_id = :reviewId", nativeQuery = true)
    public List<Reply> getAllRepliesForOneReview(@Param("reviewId") int reviewId);

    @Query(value = "SELECT reply.id, reply.review_id, reply.previous_reply_id, reply.comment " +
                   "FROM reply, review " +
                   "WHERE reply.review_id = review.id AND provider_id = :userId", nativeQuery = true)
    public List<Reply> getAllRepliesForOneUser(@Param("userId") int userIb);
}
