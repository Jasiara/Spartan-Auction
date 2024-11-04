package com.csc340.SpartanAuction.review;

import com.csc340.SpartanAuction.rating.Rating;
import com.csc340.SpartanAuction.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reviewerId")
    private User reviewUser;

    @ManyToOne
    @JoinColumn(name = "providerId")
    private User providerUser;

    private String review;

    @OneToOne
    @JoinColumn(name = "ratingId")
    private Rating rating;

    public Review(int id, User reviewUser, User providerUser, String review, Rating rating) {
        this.id = id;
        this.reviewUser = reviewUser;
        this.providerUser = providerUser;
        this.review = review;
        this.rating = rating;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getReviewUser() {
        return reviewUser;
    }

    public void setReviewUser(User reviewUser) {
        this.reviewUser = reviewUser;
    }

    public User getProviderUser() {
        return providerUser;
    }

    public void setProviderUser(User providerUser) {
        this.providerUser = providerUser;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
