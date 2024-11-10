package com.csc340.SpartanAuction.auction;

import jakarta.persistence.*;
import com.csc340.SpartanAuction.user.*;

@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double startingPrice;

    @Column(nullable = false)
    private double currentPrice;

    @Column(nullable = false)
    private String auctionStatus; // e.g., "active", "completed", "cancelled"

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller; // Reference to the User entity

    public Auction() {
    }

    public Auction(int id, String title, String description, double startingPrice, double currentPrice, String auctionStatus, User seller) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentPrice = currentPrice;
        this.auctionStatus = auctionStatus;
        this.seller = seller;
    }

    

    public Auction(String title, String description, double startingPrice, double currentPrice, String auctionStatus, User seller) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentPrice = currentPrice;
        this.auctionStatus = auctionStatus;
        this.seller = seller;
    }

    public Auction(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}