package com.csc340.SpartanAuction.bid;

import com.csc340.SpartanAuction.user.User;
//import com.csc340.SpartanAuction.item.Item;
import jakarta.persistence.*;
@Entity
@Table(name = "bids")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @Column(nullable = false)
    private double amount;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Bid() {
    }

    public Bid(int id, Item item, double amount, User user) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.user = user;
    }

    public Bid(Bid bid) {
        this.id = bid.getId();
        this.item = bid.getItem();
        this.amount = bid.getAmount();
        this.user = bid.getUser();
    }

    public Bid(Item item, double amount, User user) {
        this.item = item;
        this.amount = amount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
}
