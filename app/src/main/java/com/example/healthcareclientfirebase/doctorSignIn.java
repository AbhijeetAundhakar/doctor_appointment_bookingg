package com.example.healthcareclientfirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

public class doctorSignIn extends AppCompatActivity {
    TextView registerText;
    EditText loginUsername, loginPassword;
    Button loginButton;

    TextInputLayout emailLogin, passwordLogin;
    private FirebaseAuth mAuth;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailLogin = (TextInputLayout) findViewById(R.id.EDTLogInUsername);
        passwordLogin = (TextInputLayout) findViewById(R.id.EDTLogInPassword);
        mAuth = FirebaseAuth.getInstance();


        registerText = findViewById(R.id.registerTextView);
//        loginUsername = findViewById(R.id.EDTLogInUsername);
//        loginPassword = findViewById(R.id.EDTLogInPassword);
        loginButton = findViewById(R.id.loginButton);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorSignIn.this, doctorsSignUp.class));
            }
        });
    }

    public void signInHere(View view) {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Please wait...");
        dialog.setMessage("Please wait while Login...");
        dialog.show();

        String strEmailLogin = emailLogin.getEditText().getText().toString();
        String strPasswordLogin = passwordLogin.getEditText().getText().toString();

        mAuth.signInWithEmailAndPassword(strEmailLogin, strPasswordLogin)
                .addOnCompleteListener(doctorSignIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            dialog.dismiss();
                            Intent intent = new Intent(doctorSignIn.this, doctorsDashboard.class);
                            startActivity(intent);
                        } else {
                            dialog.dismiss();
                            emailLogin.getEditText().setText("");
                            passwordLogin.getEditText().setText("");
                            Toast.makeText(doctorSignIn.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}