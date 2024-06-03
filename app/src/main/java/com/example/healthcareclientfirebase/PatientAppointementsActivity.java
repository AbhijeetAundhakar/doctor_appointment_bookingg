package com.example.healthcareclientfirebase;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PatientAppointementsActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private appointmentDisplayAdapter adapter;
//    private ArrayList<appointmentDataModel> dataList;

    private RecyclerView recyclerView;
    private List<Booking> bookingList;
    private DatabaseHelper dbHelper;

    /*
    ----------------------------------
    ----------new code------------------
    ----------------------------------
     */
    private BookingAdapter bookingAdapter;
    private DatabaseReference reference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_appointements);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
        ------------------------------------------
        --------------NEW CODE-------------------
        ------------------------------------------
         */

        dbHelper = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerViewRequestPage);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize and show ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        loadBookings();

    }

    private void loadBookings() {
/*
 bookingList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_BOOKINGS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String firstName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_LAST_NAME));
                String problemDescription = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PROBLEM_DESCRIPTION));
                String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE));

                String dateButton = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_BUTTON_DATE));
                String timeButton = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_BUTTON_TIME));

                Booking booking = new Booking(firstName, lastName, problemDescription, date, dateButton, timeButton);
                bookingList.add(booking);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        BookingAdapter adapter = new BookingAdapter(bookingList);
        recyclerView.setAdapter(adapter);

 */








        bookingList = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("Bookings");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookingList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Booking booking = snapshot.getValue(Booking.class);
                    booking.setBookingId(snapshot.getKey()); // Assuming Booking has a setBookingId method
                    bookingList.add(booking);
                }
                bookingAdapter = new BookingAdapter(bookingList, PatientAppointementsActivity.this);
                recyclerView.setAdapter(bookingAdapter);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase", "Error fetching data", databaseError.toException());
                progressDialog.dismiss();
                Toast.makeText(PatientAppointementsActivity.this, "Failed to load bookings", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    --------------------------------
    ----------old SQLite code-------------
    --------------------------------
     */
/*
    private class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

        private List<Booking> bookings;

        BookingAdapter(List<Booking> bookings) {
            this.bookings = bookings;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_appointment_data, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Booking booking = bookings.get(position);
            holder.textName.setText("Patient Name: " + booking.getFirstName() + " " + booking.getLastName());
            holder.textProblemDescription.setText("Problem Description: " + booking.getProblemDescription());
            holder.textDate.setText("Phont No. : " + booking.getDate());
            holder.textButtonDate.setText("dateButton: " + booking.getDateButton());
            holder.textTimeButton.setText("Time: " + booking.getTimeButton());

            holder.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle accept action
                    Toast.makeText(PatientAppointementsActivity.this, "Booking accepted", Toast.LENGTH_SHORT).show();
                    // Start third activity here and pass necessary data
                }
            });

            holder.btnReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle reject action
//                    bookings.remove(booking);
//                    notifyDataSetChanged();
//                    Toast.makeText(PatientAppointementsActivity.this, "Booking rejected", Toast.LENGTH_SHORT).show();

                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.beginTransaction();
                    try {
                        String deleteQuery = "DELETE FROM " + DatabaseHelper.TABLE_BOOKINGS +
                                " WHERE " + DatabaseHelper.COLUMN_ID + " = ?";
                        db.execSQL(deleteQuery, new String[]{String.valueOf(booking.getId())});

                        // Commit the transaction
                        db.setTransactionSuccessful();

                        // If no exceptions were thrown and transaction was successful, remove the booking from the list and notify the adapter
                        bookings.remove(booking);
                        notifyDataSetChanged();
                        Toast.makeText(PatientAppointementsActivity.this, "Booking rejected and removed", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e("Delete", "Error deleting booking", e);
                        Toast.makeText(PatientAppointementsActivity.this, "Failed to reject booking", Toast.LENGTH_SHORT).show();
                    } finally {
                        db.endTransaction(); // End transaction, either commit or rollback changes
                        db.close();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return bookings.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textName, textProblemDescription, textDate, textButtonDate, textTimeButton;
            Button btnAccept, btnReject;

            ViewHolder(View itemView) {
                super(itemView);
                textName = itemView.findViewById(R.id.textName);
                textProblemDescription = itemView.findViewById(R.id.textProblemDescription);
                textDate = itemView.findViewById(R.id.textDate);

                textTimeButton = itemView.findViewById(R.id.textTime);
                textButtonDate = itemView.findViewById(R.id.textDateTime); // New TextView for displaying date button

                btnAccept = itemView.findViewById(R.id.btnAccept);
                btnReject = itemView.findViewById(R.id.btnReject);
            }
        }
    }
    */
}