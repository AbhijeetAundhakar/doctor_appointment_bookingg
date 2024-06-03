package com.example.healthcareclientfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class doctorsloginAndRegistration extends AppCompatActivity {

    Button doctorSignUpButton, doctorSignInButton, medicineOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctorslogin_and_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        doctorSignInButton = (Button) findViewById(R.id.doctorSignInButton);
        doctorSignUpButton = (Button) findViewById(R.id.signUpAsDoctorButton);
        medicineOwner = (Button) findViewById(R.id.medicineOwnerButton);

        doctorSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorsloginAndRegistration.this, doctorsSignUp.class));
            }
        });

        doctorSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorsloginAndRegistration.this, doctorSignIn.class));
            }
        });
    }
}