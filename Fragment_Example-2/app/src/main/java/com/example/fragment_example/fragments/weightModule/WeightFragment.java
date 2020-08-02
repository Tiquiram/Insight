package com.example.fragment_example.fragments.weightModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.example.fragment_example.R;
import com.example.fragment_example.databinding.FragmentWeightBinding;

public class WeightFragment extends Fragment {

    public WeightFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight, container, false);
        FragmentWeightBinding binding = DataBindingUtil.setContentView(this.getActivity(), R.layout.fragment_weight);

        return view;
    }
}
