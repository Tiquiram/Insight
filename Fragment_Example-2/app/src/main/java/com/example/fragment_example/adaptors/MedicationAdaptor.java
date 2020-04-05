package com.example.fragment_example.adaptors;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment_example.R;
import com.example.fragment_example.model.medicationModule.Medication;

import java.util.List;

public class MedicationAdaptor extends RecyclerView.Adapter<MedicationAdaptor.MyViewHolder> {

    private List<Medication> medicationList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, dosage, frequency;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.medication_name);
            dosage = (TextView) view.findViewById(R.id.medication_dosage);
            frequency = (TextView) view.findViewById(R.id.medication_frequency);
        }
    }


    public MedicationAdaptor(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medication_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Medication medication = medicationList.get(position);
        holder.name.setText(medication.getName());
        holder.dosage.setText(Double.toString(medication.getDosage()) + "mg");
        holder.frequency.setText("taken " + Integer.toString(medication.getFrequency()) + " times a day");
    }

    @Override
    public int getItemCount() {
        return medicationList.size();
    }
}