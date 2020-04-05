package com.example.fragment_example.model.medicationModule;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MedicineSearchResponse {
    @SerializedName("results")
    private List<MedicationResult> results;

    public MedicineSearchResponse(List<MedicationResult> results) {
        this.results = results;
    }

    public List<MedicationResult> getResults() {
        return this.results;
    }
    public void setResults(List<MedicationResult> results) {
        this.results = results;
    }
}
