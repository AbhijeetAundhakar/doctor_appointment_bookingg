package com.example.healthcareclientfirebase;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {
    private List<Booking> bookingList;
    private Context context;

    /*
    ----------------------------------------
    ---------------new code------------------
    ---------------------------------------
     */
    private DatabaseHelper dbHelper;

    public BookingAdapter(List<Booking> bookingList, Context context) {
        this.bookingList = bookingList;
        this.context = context;

/*
    ----------------------------------------
    ---------------new code------------------
    ---------------------------------------
     */
        this.dbHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_appointment_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Booking booking = bookingList.get(position);
        holder.textName.setText("Name : " + booking.getFirstName() + " " + booking.getLastName());
        holder.textProblemDescription.setText("Problem Description : " + booking.getProblemDescription());
        holder.textPhNumber.setText("Phone No. : " + booking.getDate());
        holder.textTime.setText("Time : " + booking.getTimeButton());
        holder.textDate.setText("Date : " + booking.getDateButton());

        holder.btnAccept.setOnClickListener(view -> {
            // Acknowledge the user
            Toast.makeText(context, "Request Accepted", Toast.LENGTH_SHORT).show();

        });

        holder.btnReject.setOnClickListener(view -> {
            // Acknowledge the user
            Toast.makeText(context, "Request Rejected", Toast.LENGTH_SHORT).show();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Bookings").child(booking.getBookingId());
            ref.removeValue().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    bookingList.remove(booking);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Booking rejected and removed", Toast.LENGTH_SHORT).show();
                    sendAcknowledgement(booking.getUserId(), "Your booking is rejected");
                } else {
                    Log.e("Firebase", "Error deleting booking", task.getException());
                    Toast.makeText(context, "Failed to reject booking", Toast.LENGTH_SHORT).show();
                }
            });

        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textProblemDescription,textPhNumber, textDate, textTime;
        public androidx.appcompat.widget.AppCompatButton btnAccept, btnReject;

        public ViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textProblemDescription = itemView.findViewById(R.id.textProblemDescription);
            textPhNumber = itemView.findViewById(R.id.textDate);

            textDate = itemView.findViewById(R.id.textDateTime);
            textTime = itemView.findViewById(R.id.textTime);
            btnAccept = itemView.findViewById(R.id.btnAccept);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }

    private void sendAcknowledgement(String userId, String message) {
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);
        userRef.child("notification").setValue(message);
    }

    private void removeBooking(Booking booking) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Bookings").child(booking.getBookingId());
        ref.removeValue().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                bookingList.remove(booking);
                notifyDataSetChanged();
                Toast.makeText(context, "Booking rejected and removed", Toast.LENGTH_SHORT).show();
                sendAcknowledgement(booking.getUserId(), "Your booking is rejected");
            } else {
                Log.e("Firebase", "Error deleting booking", task.getException());
                Toast.makeText(context, "Failed to reject booking", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
