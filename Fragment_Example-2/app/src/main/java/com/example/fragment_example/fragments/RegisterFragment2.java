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
public class RegisterFragment2 extends Fragment {
    FragmentTransaction fragmentTransaction;

    public RegisterFragment2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_register_2, container, false);
        Button btn_login =(Button) view.findViewById(R.id.btn_continue);
        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                RegisterFragment3 fragment_Register3 = new RegisterFragment3();
                fragmentTransaction.replace(R.id.main_container,fragment_Register3);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}


