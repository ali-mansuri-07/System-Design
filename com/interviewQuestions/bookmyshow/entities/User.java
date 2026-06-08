package com.interviewQuestions.bookmyshow.entities;

public class User {
    String username;
    String userId;

    public User(String username, String userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }
}
