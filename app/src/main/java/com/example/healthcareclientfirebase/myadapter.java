package com.example.healthcareclientfirebase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class myadapter extends FirebaseRecyclerAdapter<user, myadapter.MyViewHolder> {
    private final RecyclerViweInterface recyclerViweInterface;
    ArrayList<user> list;
    Context context;



    public myadapter(@NonNull FirebaseRecyclerOptions<user> options, RecyclerViweInterface recyclerViweInterface, Context context) {
        super(options);
        this.recyclerViweInterface = recyclerViweInterface;
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i, @NonNull user user) {

        myViewHolder.name.setText(user.getName());
        myViewHolder.email.setText(user.getEmail());
        myViewHolder.licenceNumber.setText(user.getLicenceNumber());
        myViewHolder.nameOfHospital.setText(user.getNameOfHospital());
        myViewHolder.speciality.setText(user.getSpecility());
        myViewHolder.yearsOfExperience.setText(user.getYearsOfExperience());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, email, licenceNumber, nameOfHospital, speciality, yearsOfExperience;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.doctorNameText);
            email = itemView.findViewById(R.id.emailText);
            licenceNumber = itemView.findViewById(R.id.licenceText);
            nameOfHospital = itemView.findViewById(R.id.nameOfHospitalText);
            speciality = itemView.findViewById(R.id.specilityText);
            yearsOfExperience = itemView.findViewById(R.id.yearsOfExperienceText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViweInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                             recyclerViweInterface.onItemClick(pos);

                            user clickedUser = getItem(pos);

                            // Create an Intent to start the new activity
                            Intent intent = new Intent(view.getContext(), doctorDetails.class);

                            // Pass relevant data to the Intent
                            intent.putExtra("name", clickedUser.getName());
                            intent.putExtra("email", clickedUser.getEmail());
                            intent.putExtra("licenceNumber", clickedUser.getLicenceNumber());
                            intent.putExtra("nameOfHospital", clickedUser.getNameOfHospital());
                            intent.putExtra("speciality", clickedUser.getSpecility());
                            intent.putExtra("yearsOfExperience", clickedUser.getYearsOfExperience());

                            // Start the new activity
                            context.startActivity(intent);
                        }
                    }
                }
            });
        }
    }
}
