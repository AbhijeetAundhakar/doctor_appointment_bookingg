package com.example.healthcareclientfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class doctorsSignUp extends AppCompatActivity {

    EditText signUpName, signUpEmail, yrsOfExp, hospitalName, specility, licenceNumber;
    TextView loginPage;
    Button signUpButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    //  new code
    TextInputLayout TILUsername, TILPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctors_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TILUsername = (TextInputLayout) findViewById(R.id.EDTSignUpUsername);
        TILPassword = (TextInputLayout) findViewById(R.id.EDTSignUpPassword);
    }

    public void process(View view){
        signUpName = findViewById(R.id.EDTSignUpName);
        signUpEmail = findViewById(R.id.EDTSignUpEmail);

        yrsOfExp = findViewById(R.id.EDTYearsOfExperience);
        hospitalName = findViewById(R.id.EDTHospitalName);
        specility = findViewById(R.id.EDTSpecility);
        licenceNumber = findViewById(R.id.EDTLicenceNumber);



        String name = signUpName.getText().toString();
        String email = signUpEmail.getText().toString();

        // new code
        String strUsername = TILUsername.getEditText().getText().toString();
        String strPassword = TILPassword.getEditText().getText().toString();

        String yearsOfExperience = yrsOfExp.getText().toString();
        String nameOfHospital = hospitalName.getText().toString();
        String specialityStr = specility.getText().toString();
        String licenceNumberStr = licenceNumber.getText().toString();

        if(name.isEmpty() || email.isEmpty() || yearsOfExperience.isEmpty() || nameOfHospital.isEmpty() || specialityStr.isEmpty() || licenceNumberStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String pattern = "[A-Z]{4}[0-9]{2}[A-Z]{2}";
        if(!licenceNumberStr.matches(pattern)) {
            Toast.makeText(this, "Invalid license number format", Toast.LENGTH_SHORT).show();
            return;
        }


        // new code
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(strUsername, strPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            TILUsername.getEditText().setText("");
                            TILPassword.getEditText().setText("");
                            Toast.makeText(doctorsSignUp.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            TILUsername.getEditText().setText("");
                            TILPassword.getEditText().setText("");
                            Toast.makeText(doctorsSignUp.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        HelperClass helperClass = new HelperClass(name, email, yearsOfExperience, nameOfHospital, specialityStr, licenceNumberStr);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Doctors");

        reference.child(name).setValue(helperClass);


        Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(doctorsSignUp.this, doctorSignIn.class));
    }
}