package com.csc340.SpartanAuction.auction;

import jakarta.persistence.*;
import com.csc340.SpartanAuction.user.*;

import java.sql.Timestamp;

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

    private double currentPrice;

    @Column(nullable = false)
    private String auctionStatus; // e.g., "active", "completed", "cancelled"

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller; // Reference to the User entity

    @Column(name = "date_and_time", nullable = false)
    private Timestamp dateAndTime;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    private String category;

    public Auction() {
    }


    public Auction(int id, String title, String description, double startingPrice, double currentPrice, String auctionStatus, User seller, Timestamp dateAndTime, String imagePath, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentPrice = currentPrice;
        this.auctionStatus = auctionStatus;
        this.seller = seller;
        this.dateAndTime = dateAndTime;
        this.imagePath = imagePath;
        this.category = category;
    }

    public Auction(Auction auction) {
        this.id = auction.getId();
        this.title = auction.getTitle();
        this.description = auction.getDescription();
        this.startingPrice = auction.getStartingPrice();
        this.currentPrice = auction.getCurrentPrice();
        this.auctionStatus = auction.getAuctionStatus();
        this.seller = auction.getSeller();
        this.dateAndTime = auction.getDateAndTime();
        this.imagePath = auction.getImagePath();
        this.category = auction.getCategory();
    }

    public Auction(String title, String description, double startingPrice, double currentPrice,
                   String auctionStatus, User seller, Timestamp dateAndTime, String imagePath, String category) {
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentPrice = currentPrice;
        this.auctionStatus = auctionStatus;
        this.seller = seller;
        this.dateAndTime = dateAndTime;
        this.imagePath = imagePath;
        this.category = category;
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

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}