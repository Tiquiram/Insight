package com.example.fragment_example.network;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MedicationAPI {

    @GET("/drug/label.json")
    Call<MedicineSearchResponse> getMedicationByName(@Query("search") String brandName, @Query("limit") String limit);

}
