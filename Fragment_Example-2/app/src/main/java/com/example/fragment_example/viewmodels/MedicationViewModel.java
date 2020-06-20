package com.example.fragment_example.viewmodels;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;
import com.example.fragment_example.network.repository.MedicationRepository;

public class MedicationViewModel extends ViewModel {
    private MutableLiveData<MedicineSearchResponse> mutableLiveData;
    private MedicationRepository medicationRepository;

    public void init(String medicationName, String limit) {
        if(mutableLiveData != null) {
            return;
        }
        else {
            medicationRepository = MedicationRepository.getInstance();
            Log.d("calling", "making api call");
            mutableLiveData = medicationRepository.getMedicationByName(medicationName, limit);
        }
    }

    public LiveData<MedicineSearchResponse> getMedicineRepository() {
        return mutableLiveData;
    }
}
