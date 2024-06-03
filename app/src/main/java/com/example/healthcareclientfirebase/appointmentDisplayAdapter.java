package com.example.healthcareclientfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class appointmentDisplayAdapter extends RecyclerView.Adapter<appointmentDisplayAdapter.ViewHolder>{
    private Context context;
    private ArrayList<appointmentDataModel> dataList;

    public appointmentDisplayAdapter(Context context, ArrayList<appointmentDataModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.patient_appointment_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        appointmentDataModel data = dataList.get(position);
        holder.txtName.setText(data.getName());
        holder.txtProblem.setText(data.getProblem());
        holder.txtDateTime.setText(data.getDate());
        holder.txtTime.setText(data.getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtProblem, txtDateTime, txtTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            txtName = itemView.findViewById(R.id.txtName);
//            txtProblem = itemView.findViewById(R.id.txtProblem);
//            txtDateTime = itemView.findViewById(R.id.txtDateTime);
//            txtTime = itemView.findViewById(R.id.txtTime);
        }
    }
}
