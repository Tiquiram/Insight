package com.example.fragment_example.network.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.fragment_example.model.loginRegisterModule.LoginRequest;
import com.example.fragment_example.model.loginRegisterModule.RegisterLoginResponse;
import com.example.fragment_example.model.loginRegisterModule.RegisterRequest;
import com.example.fragment_example.model.loginRegisterModule.User;
import com.example.fragment_example.network.RetrofitService;
import com.example.fragment_example.network.UserAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository userRepository;

    public static UserRepository getInstance() {
        if(userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    private UserAPI userApi;

    public UserRepository() {
        userApi = RetrofitService.createService(UserAPI.class);
    }

    public MutableLiveData<List<User>> getUsers() {
        final MutableLiveData<List<User>> userData = new MutableLiveData<>();
        userApi.getAllUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    userData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                userData.setValue(null);
            }
        });

        return userData;
    }

    public MutableLiveData<RegisterLoginResponse> registerUser(String username, String email, String password) {
        final MutableLiveData<RegisterLoginResponse> userData = new MutableLiveData<>();
        userApi.registerUser(new RegisterRequest(username, email, password)).enqueue(new Callback<RegisterLoginResponse>() {
            @Override
            public void onResponse(Call<RegisterLoginResponse> call, Response<RegisterLoginResponse> response) {
                if (response.isSuccessful()){
                    userData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RegisterLoginResponse> call, Throwable t) {
                userData.setValue(null);
            }
        });

        return userData;
    }

    public MutableLiveData<RegisterLoginResponse> loginUser(String username, String password) {
        final MutableLiveData<RegisterLoginResponse> userData = new MutableLiveData<>();
        userApi.loginUser(new LoginRequest(username, password)).enqueue(new Callback<RegisterLoginResponse>() {
            @Override
            public void onResponse(Call<RegisterLoginResponse> call, Response<RegisterLoginResponse> response) {
                if (response.isSuccessful()){
                    userData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RegisterLoginResponse> call, Throwable t) {
                userData.setValue(null);
            }
        });

        return userData;
    }

}
