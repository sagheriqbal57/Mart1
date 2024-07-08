package com.project.e_mart.domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String description;
    private String picUrl;
    private int review;
    private int numberInCart;
    private double score;

    private float feeTxt;

    public PopularDomain(float price) {
        this.feeTxt = feeTxt;
    }

    public float getPrice() {
        return feeTxt;
    }

    public void setPrice(float price) {
        this.feeTxt = feeTxt;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public PopularDomain(String title, String description, String picUrl, int review, double score,float feeTxt) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.review = review;
        //this.numberInCart = numberInCart;
        this.score = score;
        this.feeTxt = feeTxt;
    }
}
