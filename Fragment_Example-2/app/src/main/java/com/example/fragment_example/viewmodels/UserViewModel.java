package com.example.fragment_example.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragment_example.model.loginRegisterModule.User;
import com.example.fragment_example.network.repository.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> mutableLiveData;
    private UserRepository userRepository;

    public void init() {
        if(mutableLiveData != null) {
            return;
        }
        else {
            userRepository = UserRepository.getInstance();
            mutableLiveData = userRepository.getUsers();
        }
    }

    public LiveData<List<User>> getUserRepository() {
        return mutableLiveData;
    }
}
