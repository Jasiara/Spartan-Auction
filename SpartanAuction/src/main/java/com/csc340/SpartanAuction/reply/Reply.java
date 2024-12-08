package com.csc340.SpartanAuction.reply;

import com.csc340.SpartanAuction.review.Review;
import jakarta.persistence.*;

@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "previousReplyId")
    private Reply previousReply;

    private String comment;

    public Reply(int id, Review review, Reply previousReply, String comment) {
        this.id = id;
        this.review = review;
        this.previousReply = previousReply;
        this.comment = comment;
    }

    public Reply() {
    }

    public Reply(Review review, Reply previousReply, String comment) {
        this.review = review;
        this.previousReply = previousReply;
        this.comment = comment;
    }

    public Reply(Reply reply) {
        this.id = reply.getId();
        this.review = reply.getReview();
        this.previousReply = reply.getPreviousReply();
        this.comment = reply.getComment();
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

    public Reply getPreviousReply() {
        return previousReply;
    }

    public void setPreviousReply(Reply previousReply) {
        this.previousReply = previousReply;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", review=" + review +
                ", previousReply=" + previousReply +
                ", comment='" + comment + '\'' +
                '}';
    }
}
