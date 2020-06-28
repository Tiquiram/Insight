package com.example.fragment_example.network.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fragment_example.network.MedicationAPI;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;
import com.example.fragment_example.network.RetrofitServiceOpenFDA;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicationRepository {
    private final MutableLiveData<MedicineSearchResponse> medicationData;

//    public static MedicationRepository getInstance() {
//        if(medicationRepository == null) {
//            medicationRepository = new MedicationRepository();
//        }
//        return medicationRepository;
//    }

    private MedicationAPI medicationAPI;

    public MedicationRepository() {
        medicationData = new MutableLiveData<>();
        medicationAPI = RetrofitServiceOpenFDA.createService(MedicationAPI.class);
    }

    public void getMedicationByName(String medicationName, String limit) {
        medicationAPI.getMedicationByName("openfda.brand_name:" + medicationName, limit).enqueue(new Callback<MedicineSearchResponse>() {
            @Override
            public void onResponse(@NonNull  Call<MedicineSearchResponse> call, @NonNull Response<MedicineSearchResponse> response) {
                if (response.isSuccessful()){
                    Log.d("fetched", "Data success");
                    medicationData.setValue(response.body());
                }
                else {
                    Log.d("something", "weird happened");
                    Log.d("response", response.message());
                    Log.d("response", response.code() + "");
                    Log.d("response", response.errorBody() + "");

                }
            }
            @Override
            public void onFailure(@NonNull  Call<MedicineSearchResponse> call, @NonNull  Throwable t) {
                medicationData.postValue(null);
            }
        });
//        final MutableLiveData<MedicineSearchResponse> medicationData = new MutableLiveData<>();
//        Log.d("get", "getting medication data");
//        medicationAPI.getMedicationByName("openfda.brand_name:" + medicationName, limit).enqueue(new Callback<MedicineSearchResponse>() {
//            @Override
//            public void onResponse(Call<MedicineSearchResponse> call, Response<MedicineSearchResponse> response) {
//                if (response.isSuccessful()){
//                    Log.d("fetched", "Data success");
//                    medicationData.setValue(response.body());
//                }
//                else {
//                    Log.d("something", "weird happened");
//                    Log.d("response", response.message());
//                    Log.d("response", response.code() + "");
//                    Log.d("response", response.errorBody() + "");
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MedicineSearchResponse> call, Throwable t) {
//                Log.d("Error!!!", t.getMessage());
//                medicationData.setValue(null);
//            }
//        });
//        return medicationData;
    }

    public LiveData<MedicineSearchResponse> getMedicationLiveData() {
        return medicationData;
    }
}
