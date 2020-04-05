package com.example.fragment_example.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragment_example.model.loginRegisterModule.RegisterLoginResponse;
import com.example.fragment_example.network.repository.UserRepository;


public class RegisterViewModel extends ViewModel {
    private MutableLiveData<RegisterLoginResponse> mutableLiveData;
    private UserRepository userRepository;

    public void init(String username, String email, String password) {
        if(mutableLiveData != null) {
            return;
        }
        else {
            userRepository = UserRepository.getInstance();
            mutableLiveData = userRepository.registerUser(username, email, password);
        }
    }

    public LiveData<RegisterLoginResponse> getUserRepository() {
        return mutableLiveData;
    }
}
