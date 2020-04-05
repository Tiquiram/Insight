package com.example.fragment_example.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragment_example.R;

public class RegisterFragment extends Fragment {

    FragmentTransaction fragmentTransaction;
    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_register, container, false);
        Button btn_login =(Button) view.findViewById(R.id.btn_continue);
        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                RegisterFragment2 fragment_Register2 = new RegisterFragment2();
                fragmentTransaction.replace(R.id.main_container,fragment_Register2);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}