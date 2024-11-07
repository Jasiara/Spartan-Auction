package com.csc340.demo.Item;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    private double amount;

    @Column(name = "provider_id")
    private int providerId;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @Column(name = "image_path")
    private String imagePath;

    @Column(columnDefinition = "TEXT")
    private String info;

    @Column(name = "start_bid")
    private double startBid;

    @Column(name = "highest_bid")
    private double highestBid;

    private String category;

    private String status;

    // Constructors
    public Item(int id, String name, double amount, int providerId, LocalDateTime dateAndTime, String imagePath, String info, double startBid, double highestBid, String category, String status) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.providerId = providerId;
        this.dateAndTime = dateAndTime;
        this.imagePath = imagePath;
        this.info = info;
        this.startBid = startBid;
        this.highestBid = highestBid;
        this.category = category;
        this.status = status;
    }

    public Item(String name, double amount, int providerId, LocalDateTime dateAndTime, String imagePath, String info, double startBid, double highestBid, String category, String status) {
        this.name = name;
        this.amount = amount;
        this.providerId = providerId;
        this.dateAndTime = dateAndTime;
        this.imagePath = imagePath;
        this.info = info;
        this.startBid = startBid;
        this.highestBid = highestBid;
        this.category = category;
        this.status = status;
    }

    public Item() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getStartBid() {
        return startBid;
    }

    public void setStartBid(double startBid) {
        this.startBid = startBid;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}