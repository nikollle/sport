package com.aricenter.sport.dto;

import com.aricenter.sport.entity.User;

import java.util.List;

public class UserResponse {
    private String message;
    private List<User> data;

    public UserResponse(String message, List<User> data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public List<User> getData() {
        return data;
    }
}
