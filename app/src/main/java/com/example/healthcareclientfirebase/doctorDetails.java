package com.example.healthcareclientfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class doctorDetails extends AppCompatActivity {

    TextView textName, textEmail, textLicenceNumber, textNameOfHospital, textSpeciality, textYearsOfExperience;
    Button bookAppoinmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textName = (TextView) findViewById(R.id.DDNameTextview);
        textEmail = (TextView) findViewById(R.id.DDEmailTextview);
        textLicenceNumber = (TextView) findViewById(R.id.DDLicenceNumberTextview);
        textNameOfHospital = (TextView) findViewById(R.id.DDHospitalNameTextview);
        textSpeciality = (TextView) findViewById(R.id.DDSpecilityTextview);
        textYearsOfExperience = (TextView) findViewById(R.id.DDYrsOfExperienceTextview);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String licenceNumber = intent.getStringExtra("licenceNumber");
        String nameOfHospital = intent.getStringExtra("nameOfHospital");
        String speciality = intent.getStringExtra("speciality");
        String yearsOfExperience = intent.getStringExtra("yearsOfExperience");

        textName.setText(name);
        textEmail.setText(email);
        textLicenceNumber.setText(licenceNumber);
        textNameOfHospital.setText(nameOfHospital);
        textSpeciality.setText(speciality);
        textYearsOfExperience.setText(yearsOfExperience);

        bookAppoinmentButton = (Button) findViewById(R.id.bookAppoinmentButton);

        bookAppoinmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorDetails.this, bookingForm.class));
            }
        });
    }
}