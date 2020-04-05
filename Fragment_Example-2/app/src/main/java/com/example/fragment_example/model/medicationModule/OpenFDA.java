package com.example.fragment_example.model.medicationModule;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenFDA {
    @SerializedName("brand_name")
    List<String> brandName;
    @SerializedName("generic_name")
    List<String> genericName;
    @SerializedName("manufacturer_name")
    List<String> manufacturerName;

    public OpenFDA(List<String> brandName, List<String> genericName, List<String> manufacturerName) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.manufacturerName = manufacturerName;
    }

    public List<String> getBrandName() {
        return this.brandName;
    }
    public List<String> getGenericName() {
        return this.genericName;
    }
    public List<String> getManufacturerName() {
        return this.manufacturerName;
    }
}
