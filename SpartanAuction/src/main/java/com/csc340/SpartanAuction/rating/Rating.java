package com.csc340.SpartanAuction.rating;

import com.csc340.SpartanAuction.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private double rating;

    public Rating() {
    }


    public Rating(User user) {
        this.user = new User();
    }

    public Rating(User user, double rating) {
        this.user = user;
        this.rating = rating;
    }

    public Rating(int id) {
        this.id = id;
    }

    public Rating(Rating rating) {
        this.id = rating.getId();
        this.user = rating.getUser();
        this.rating = rating.getRating();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", user=" + user +
                ", rating=" + rating +
                '}';
    }
}
