package com.example.fragment_example.viewmodels;
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
            mutableLiveData = medicationRepository.getMedicationByName(medicationName, limit);
        }
    }

    public LiveData<MedicineSearchResponse> getMedicineRepository() {
        return mutableLiveData;
    }
}
