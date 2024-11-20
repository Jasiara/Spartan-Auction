package com.csc340.SpartanAuction.review;

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

    @Column(nullable = false)
    private double rating;

    public Review(int id, User reviewUser, User providerUser, String review, double rating) {
        this.id = id;
        this.reviewUser = reviewUser;
        this.providerUser = providerUser;
        this.review = review;
        this.rating = rating;
    }

    public Review() {
    }

    public Review(User reviewUser, User providerUser, String review, double rating) {
        this.reviewUser = reviewUser;
        this.providerUser = providerUser;
        this.review = review;
        this.rating = rating;
    }

    public Review(int id) {
        this.id = id;
    }

    public Review(User reviewUser, User providerUser, double rating) {
        this.reviewUser = reviewUser;
        this.providerUser = providerUser;
        this.rating = rating;
    }

    public Review(Review review) {
        this.id = review.getId();
        this.reviewUser = review.getReviewUser();
        this.providerUser = review.getProviderUser();
        this.review = review.getReview();
        this.rating = review.getRating();
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewUser=" + reviewUser +
                ", providerUser=" + providerUser +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }
}
