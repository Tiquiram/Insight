package com.example.fragment_example.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.fragment_example.fragments.medicationModule.AddMedicationFragment;
import com.example.fragment_example.fragments.medicationModule.MedicationFragment;
import com.example.fragment_example.R;

public class HomepageFragment extends Fragment {
    FragmentTransaction fragmentTransaction;
    GridLayout mainGrid ;
    public HomepageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        Toolbar toolbar =(Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        mainGrid =(GridLayout)view.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
        return view;
    }
    private void setSingleEvent(GridLayout mainGrid){
        for (int i=0; i<mainGrid.getChildCount();i++){
            final int finalI = i;
            CardView cardView =(CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(finalI == 0){
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        GlucoseFragment fragmentGlucose = new GlucoseFragment();
                        fragmentTransaction.replace(R.id.main_container,fragmentGlucose);
                        fragmentTransaction.commit();
                    }else if(finalI==1){
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        AddMedicationFragment medicationFragment = new AddMedicationFragment();
                        fragmentTransaction.replace(R.id.main_container, medicationFragment);
                        fragmentTransaction.commit();
                    }else if(finalI==2){

                    }else if(finalI==3){

                    }else if(finalI==4){

                    }else{

                    }
                }
            });

        }
    }
}
