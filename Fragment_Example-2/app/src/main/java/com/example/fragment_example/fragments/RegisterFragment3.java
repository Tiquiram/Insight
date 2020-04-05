package com.example.fragment_example.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragment_example.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment3 extends Fragment {

    FragmentTransaction fragmentTransaction;
    public RegisterFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_register_3, container, false);
        Button btn_login =(Button) view.findViewById(R.id.btn_continue);
        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                HomepageFragment fragmentHompage = new HomepageFragment();
                fragmentTransaction.replace(R.id.main_container,fragmentHompage);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
