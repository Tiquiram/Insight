package com.example.fragment_example.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragment_example.R;


public class LoginFragment extends Fragment {

    FragmentTransaction fragmentTransaction;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_login, container, false);
        TextView et_sign_up =(TextView) view.findViewById(R.id.et_sign_up);
        et_sign_up.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                RegisterFragment fragment_register = new RegisterFragment();
                fragmentTransaction.replace(R.id.main_container, fragment_register);
                fragmentTransaction.commit();
            }
        });
        Button btn_login =(Button) view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                HomepageFragment fragment_homepage = new HomepageFragment();
                fragmentTransaction.replace(R.id.main_container,fragment_homepage);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}