package com.example.fragment_example.network.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.fragment_example.model.loginRegisterModule.LoginRequest;
import com.example.fragment_example.model.loginRegisterModule.RegisterLoginResponse;
import com.example.fragment_example.model.loginRegisterModule.RegisterRequest;
import com.example.fragment_example.network.MedicationAPI;
import com.example.fragment_example.network.RetrofitService;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;
import com.example.fragment_example.network.RetrofitServiceOpenFDA;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicationRepository {
    private static MedicationRepository medicationRepository;

    public static MedicationRepository getInstance() {
        if(medicationRepository == null) {
            medicationRepository = new MedicationRepository();
        }
        return medicationRepository;
    }

    private MedicationAPI medicationAPI;

    public MedicationRepository() {
        medicationAPI = RetrofitServiceOpenFDA.createService(MedicationAPI.class);
    }


    public MutableLiveData<MedicineSearchResponse> getMedicationByName(String medicationName, String limit) {
        final MutableLiveData<MedicineSearchResponse> medicationData = new MutableLiveData<>();
        medicationAPI.getMedicationByName("openfda.brand_name:" + medicationName, limit).enqueue(new Callback<MedicineSearchResponse>() {
            @Override
            public void onResponse(Call<MedicineSearchResponse> call, Response<MedicineSearchResponse> response) {
                if (response.isSuccessful()){
                    medicationData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MedicineSearchResponse> call, Throwable t) {
                Log.d("Error!!!", t.getMessage());
                medicationData.setValue(null);
            }
        });

        return medicationData;
    }
}
