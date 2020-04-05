package com.example.fragment_example.model.medicationModule;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MedicationResult {
    @SerializedName("description")
    List<String> description;
    @SerializedName("information_for_patients")
    List<String> informationForPatients;
    @SerializedName("openfda")
    OpenFDA openFDA;

    public MedicationResult(List<String> description, List<String> informationForPatients, OpenFDA openFDA) {
        this.description = description;
        this.informationForPatients = informationForPatients;
        this.openFDA = openFDA;
    }

    public List<String> getDescription() {
        return this.description;
    }
    public  List<String> getInformationForPatients() {
        return  this.informationForPatients;
    }
    public OpenFDA getOpenFDA() {
        return openFDA;
    }
}
