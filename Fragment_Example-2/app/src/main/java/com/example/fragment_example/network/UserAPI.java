package com.example.fragment_example.network;

import com.example.fragment_example.model.loginRegisterModule.LoginRequest;
import com.example.fragment_example.model.loginRegisterModule.RegisterLoginResponse;
import com.example.fragment_example.model.loginRegisterModule.RegisterRequest;
import com.example.fragment_example.model.loginRegisterModule.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserAPI {

    @GET("/api/accounts/users/")
    Call<List<User>> getAllUsers();

    @Headers("Content-Type: application/json")
    @POST("/api/accounts/login")
    Call<RegisterLoginResponse> loginUser(@Body LoginRequest loginRequest);

    @Headers("Content-Type: application/json")
    @POST("/api/accounts/register")
    Call<RegisterLoginResponse> registerUser(@Body RegisterRequest registerRequest);

}
