package com.example.fragment_example.viewmodels;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragment_example.model.medicationModule.Medication;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;
import com.example.fragment_example.network.repository.MedicationRepository;

public class MedicationViewModel extends AndroidViewModel {
    private LiveData<MedicineSearchResponse> medicationLiveData;
    private MedicationRepository medicationRepository;

    public MedicationViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        medicationRepository = new MedicationRepository();
        Log.d("calling", "making api call");
        medicationLiveData = medicationRepository.getMedicationLiveData();
    }

    public void searchForMedication(String medicationName, String limit) {
        medicationRepository.getMedicationByName(medicationName, limit);
    }

    public LiveData<MedicineSearchResponse> getMedicationLiveData() {
        return medicationLiveData;
    }

}