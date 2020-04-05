package com.example.fragment_example.fragments.medicationModule;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment_example.adaptors.MedicationAdaptor;
import com.example.fragment_example.R;
import com.example.fragment_example.databinding.FragmentMedicationBinding;
import com.example.fragment_example.model.medicationModule.Medication;
import com.example.fragment_example.model.medicationModule.MedicationResult;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;

import com.example.fragment_example.network.RetrofitService;
import com.example.fragment_example.network.RetrofitServiceOpenFDA;
import com.example.fragment_example.viewmodels.MedicationViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicationFragment extends Fragment {

    FragmentTransaction fragmentTransaction;
    private List<Medication> medicationList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MedicationAdaptor medicationAdaptor;


    MedicineSearchResponse medicineSearchResponse;
    MedicationViewModel medicationViewModel;

    public MedicationFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_medication, container, false);
        FragmentMedicationBinding binding = DataBindingUtil.setContentView(this.getActivity(), R.layout.fragment_medication);

        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        AddMedicationFragment addMedicationFragment = new AddMedicationFragment();

        recyclerView = binding.medicationRecyclerView;

        medicationAdaptor = new MedicationAdaptor(medicationList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(medicationAdaptor);


        Log.d("trying to get data", "trying to get data");
        medicationViewModel = ViewModelProviders.of(this).get(MedicationViewModel.class);
        medicationViewModel.init("lipitor", "1");
        medicationViewModel.getMedicineRepository().observe(this, response -> {
            if(response != null) {
                medicineSearchResponse = new MedicineSearchResponse(response.getResults());
                Log.d("get medicine response", medicineSearchResponse.getResults().size() + " is the size of gthe results");
                for(MedicationResult res : medicineSearchResponse.getResults()) {
                    Log.d("medicine name", res.getOpenFDA().getBrandName().get(0));
                    Log.d("description", res.getDescription().get(0));
                    Log.d("info for patients", res.getInformationForPatients().get(0));
                }
            }
            else {
                Log.d("error??", "failed");
            }
        });



        prepareMedicationData();


        // data binding for medication fragment
        binding.addMedicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test", "test click");
                fragmentTransaction.replace(R.id.main_container, addMedicationFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void prepareMedicationData() {
        Medication medication = new Medication("Metformin", 200, "mg", 2);
        medicationList.add(medication);
        medication = new Medication("Januvia", 500, "mg", 1);
        medicationList.add(medication);
        medication = new Medication("Victoza", 100, "mg", 3);
        medicationList.add(medication);
        medication = new Medication("Glipizide", 200, "mg", 2);
        medicationList.add(medication);
        medication = new Medication("Amaryl", 100, "mg", 3);
        medicationList.add(medication);
        medication = new Medication("Actos", 300, "mg", 1);
        medicationList.add(medication);


        medicationAdaptor.notifyDataSetChanged();
    }
}
