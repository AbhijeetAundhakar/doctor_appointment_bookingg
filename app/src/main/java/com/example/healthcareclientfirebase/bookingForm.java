package com.example.healthcareclientfirebase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class bookingForm extends AppCompatActivity {

    /*
    --------------------------------------
    --------------NEW CODE-----------------
    --------------------------------------
     */
    private EditText etFirstName, etLastName, etProblemDescription, etDate;
    private Button btnSubmit;
    private DatabaseHelper dbHelper;

    private Button buttonDate, buttonTime;
/*
--------------------------------------
--------------NEW CODE-----------------
--------------------------------------
 */
private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


       /*
--------------------------------------
--------------NEW CODE-----------------
--------------------------------------
 */
        dbHelper = new DatabaseHelper(this);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etProblemDescription = findViewById(R.id.etProblemDescription);
        etDate = findViewById(R.id.etDate);

        buttonDate = findViewById(R.id.buttonDate);
        buttonTime = findViewById(R.id.buttonTime);

        btnSubmit = findViewById(R.id.btnSubmit);


        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Bookings");

        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Date Picker
                DatePickerDialog datePickerDialog = new DatePickerDialog(bookingForm.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                buttonDate.setText(date); // Set selected date on button
                            }
                        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Time Picker
                TimePickerDialog timePickerDialog = new TimePickerDialog(bookingForm.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String time = hourOfDay + ":" + minute;
                                buttonTime.setText(time); // Set selected time on button
                            }
                        }, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBooking();
            }
        });



        /*
        ------------------------------------------
        -----------------NEW CODE-----------------
        ------------------------------------------
         */
    }

    private void insertBooking() {

        /*
        ---------------------------------------
        --------------SQLITE CODE---------------
        -----------------------------------------
         */
        /*
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FIRST_NAME, etFirstName.getText().toString());
        values.put(DatabaseHelper.COLUMN_LAST_NAME, etLastName.getText().toString());
        values.put(DatabaseHelper.COLUMN_PROBLEM_DESCRIPTION, etProblemDescription.getText().toString());
        values.put(DatabaseHelper.COLUMN_DATE, etDate.getText().toString());

        values.put(DatabaseHelper.COLUMN_BUTTON_DATE, buttonDate.getText().toString()); // Assuming etDate is your EditText for date
        values.put(DatabaseHelper.COLUMN_BUTTON_TIME, buttonTime.getText().toString());

        long newRowId = db.insert(DatabaseHelper.TABLE_BOOKINGS, null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Booking added successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add booking", Toast.LENGTH_SHORT).show();
        }
        db.close();
         */




        /*
        ------------------------------------
        -------------NEW CODE--------------
        -----------------------------------
         */
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String problemDescription = etProblemDescription.getText().toString();
        String date = etDate.getText().toString();
        String buttonDateText = buttonDate.getText().toString();
        String buttonTimeText = buttonTime.getText().toString();
        String bookingId = FirebaseDatabase.getInstance().getReference().push().getKey();

// Assuming userId is the currently authenticated user's ID
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();



        if(firstName.isEmpty() || lastName.isEmpty() || problemDescription.isEmpty() || date.isEmpty() || buttonDateText.isEmpty() || buttonTimeText.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Booking booking = new Booking(bookingId, userId,firstName, lastName, problemDescription, date, buttonDateText, buttonTimeText);

        String bookingIdMain = reference.push().getKey();
        if (bookingIdMain != null) {
            reference.child(bookingIdMain).setValue(booking)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(this, "Booking added successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(bookingForm.this, bookingStatusPage.class));
                        finish();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Failed to add booking", Toast.LENGTH_SHORT).show();
                    });
        }
    }
}