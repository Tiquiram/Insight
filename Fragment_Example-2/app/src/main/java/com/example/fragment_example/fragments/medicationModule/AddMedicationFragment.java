package com.example.fragment_example.fragments.medicationModule;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragment_example.R;
import com.example.fragment_example.adaptors.MedicationSearchAdaptor;
import com.example.fragment_example.databinding.FragmentAddMedicationBinding;
import com.example.fragment_example.model.medicationModule.MedicationResult;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;
import com.example.fragment_example.viewmodels.MedicationViewModel;

public class AddMedicationFragment extends Fragment {

    MedicineSearchResponse medicineSearchResponse;
    MedicationViewModel medicationViewModel;
    private RecyclerView recyclerView;
    private MedicationSearchAdaptor medicationSearchAdaptor;

    public AddMedicationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_add_medication, container, false);
        FragmentAddMedicationBinding binding = DataBindingUtil.setContentView(this.getActivity(), R.layout.fragment_add_medication);

        recyclerView = binding.medicationSearchRecyclerView;

        medicationSearchAdaptor = new MedicationSearchAdaptor(medicineSearchResponse);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(medicationSearchAdaptor);
        medicationSearchAdaptor.notifyDataSetChanged();

        medicationViewModel = ViewModelProviders.of(AddMedicationFragment.this).get(MedicationViewModel.class);
        medicationViewModel.init();
        medicationViewModel.getMedicationLiveData().observe(AddMedicationFragment.this, response -> {
            if(response != null) {
              medicineSearchResponse = new MedicineSearchResponse(response.getResults());

                Log.d("get medicine response", medicineSearchResponse.getResults().size() + " is the size of the results");
                for(MedicationResult res : medicineSearchResponse.getResults()) {
                    Log.d("medicine name", res.getOpenFDA().getBrandName().get(0));
//                    Log.d("description", res.getDescription().get(0));
//                    Log.d("info for patients", res.getInformationForPatients().get(0));
                }
                medicationSearchAdaptor.setData(medicineSearchResponse);
            }
            else {
                Log.d("error??", "failed");
                medicationSearchAdaptor.notifyDataSetChanged();
            }
        });


        binding.medicineSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            public boolean onQueryTextSubmit(String query) {
                binding.medicineSearch.clearFocus();     // Close keyboard on pressing IME_ACTION_SEARCH option
                Log.d("SEARCH IS", "QueryTextSubmit : "+ query);
                //load search query
                Log.d("trying to get data", query);
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("TEXT CHANGE IS ", "QueryTextChange: "+ newText);
                return false;
            }
        });

        return view;
    }

    public void performSearch(String query) {
        medicationViewModel.searchForMedication(query, "50");
    }
//    private void prepareMedicationData() {
//        Medication medication = new Medication("Metformin", 200, "mg", 2);
//        medicationList.add(medication);
//        medication = new Medication("Januvia", 500, "mg", 1);
//        medicationList.add(medication);
//        medication = new Medication("Victoza", 100, "mg", 3);
//        medicationList.add(medication);
//        medication = new Medication("Glipizide", 200, "mg", 2);
//        medicationList.add(medication);
//        medication = new Medication("Amaryl", 100, "mg", 3);
//        medicationList.add(medication);
//        medication = new Medication("Actos", 300, "mg", 1);
//        medicationList.add(medication);
//
//
//        medicationSearchAdaptor.notifyDataSetChanged();
//    }
}

