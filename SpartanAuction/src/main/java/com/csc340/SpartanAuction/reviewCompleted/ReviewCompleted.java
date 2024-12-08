package com.csc340.SpartanAuction.reviewCompleted;

import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.review.Review;
import jakarta.persistence.*;

@Entity
@Table(name = "reviewCompleted")
public class ReviewCompleted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    @OneToOne
    @JoinColumn(name = "auctionId")
    private Auction auction;

    @Column(nullable = false)
    private boolean reviewCompleted;

    public ReviewCompleted(int id, Review review, Auction auction, boolean reviewCompleted) {
        this.id = id;
        this.review = review;
        this.auction = auction;
        this.reviewCompleted = reviewCompleted;
    }

    public ReviewCompleted() {
    }

    public ReviewCompleted(Review review, Auction auction, boolean reviewCompleted) {
        this.review = review;
        this.auction = auction;
        this.reviewCompleted = reviewCompleted;
    }

    public ReviewCompleted(int id) {
        this.id = id;
    }

    public ReviewCompleted(ReviewCompleted reviewCompleted) {
        this.id = reviewCompleted.getId();
        this.review = reviewCompleted.getReview();
        this.auction = reviewCompleted.getAuction();
        this.reviewCompleted = reviewCompleted.isReviewCompleted();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public boolean isReviewCompleted() {
        return reviewCompleted;
    }

    public void setReviewCompleted(boolean reviewCompleted) {
        this.reviewCompleted = reviewCompleted;
    }

    @Override
    public String toString() {
        return "ReviewCompleted{" +
                "id=" + id +
                ", review=" + review +
                ", auction=" + auction +
                ", reviewCompleted=" + reviewCompleted +
                '}';
    }
}
