package com.example.fragment_example.adaptors;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment_example.R;
import com.example.fragment_example.model.medicationModule.MedicationResult;
import com.example.fragment_example.model.medicationModule.MedicineSearchResponse;

public class MedicationSearchAdaptor extends RecyclerView.Adapter<MedicationSearchAdaptor.MyViewHolder> {

    public MedicineSearchResponse searchResponse;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;

        public MyViewHolder(View view) {
            super(view);
            Log.d("holder", "view holder");
            name = (TextView) view.findViewById(R.id.medication_search_name);
            description = (TextView) view.findViewById(R.id.medication_search_description);
        }
    }


    public MedicationSearchAdaptor(MedicineSearchResponse searchResponse) {
        Log.d("set", "setting response");
        this.searchResponse = searchResponse;
    }

    public void setData(MedicineSearchResponse searchResponse) {
        this.searchResponse= searchResponse;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("inflate", "inflating");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medication_search_result_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("test", "in adaptor");
        MedicationResult medicationResult = searchResponse.getResults().get(position);
        holder.name.setText(medicationResult.getOpenFDA().getBrandName().get(0));
        holder.description.setText(medicationResult.getDescription().get(0));
    }

    @Override
    public int getItemCount() {
        return searchResponse != null ? searchResponse.getResults().size() : 0;
    }
}