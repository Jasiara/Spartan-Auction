package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.auction.Auction;
import com.csc340.SpartanAuction.user.User;
import jakarta.persistence.*;
@Entity
@Table(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "auctionId")
    private Auction auction;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Bid() {
    }

    public Bid(int id, Auction auction, double amount, User user) {
        this.id = id;
        this.auction = auction;
        this.amount = amount;
        this.user = user;
    }

    public Bid(Bid bid) {
        this.id = bid.getId();
        this.auction = bid.getAuction();
        this.amount = bid.getAmount();
        this.user = bid.getUser();
    }

    public Bid(Auction auction, double amount, User user) {
        this.auction = auction;
        this.amount = amount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", auction=" + auction +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
