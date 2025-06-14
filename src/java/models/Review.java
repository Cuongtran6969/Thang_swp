/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Review {
    private int id, userId, tourId, rating;
    private String comment, username, status;
    private Date reviewDate;

    public Review() {
    }

    public Review(int id, int userId, int tourId, int rating, String comment, String username, String status, Date reviewDate) {
        this.id = id;
        this.userId = userId;
        this.tourId = tourId;
        this.rating = rating;
        this.comment = comment;
        this.username = username;
        this.status = status;
        this.reviewDate = reviewDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", userId=" + userId + ", tourId=" + tourId + ", rating=" + rating + ", comment=" + comment + ", username=" + username + ", reviewDate=" + reviewDate + '}';
    }
}
