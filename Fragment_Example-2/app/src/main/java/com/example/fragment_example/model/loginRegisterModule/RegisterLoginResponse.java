package com.example.fragment_example.model.loginRegisterModule;

import com.google.gson.annotations.SerializedName;

public class RegisterLoginResponse {
    @SerializedName("user")
    private User user;

    @SerializedName("token")
    private String token;

    public RegisterLoginResponse(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
