package com.example.healthcareclientfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button loginButton, registerButton;
    LinearLayout lineaerAnim;
    TextView welcomeTextAnim;

    //  DOCTORS PAGE
    Button doctorSignUpButton, doctorSignInButton, medicineOwner;
    LinearLayout linearAnim;

    TextView welcomeText;

    CardView doctorsLoginCardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginButton = (Button) findViewById(R.id.buttonLogin);
        registerButton = (Button) findViewById(R.id.buttonRegister);
        lineaerAnim = (LinearLayout) findViewById(R.id.linearLayoutAnim);
        welcomeTextAnim = (TextView) findViewById(R.id.welcomeTextAnim);
        doctorsLoginCardview = (CardView) findViewById(R.id.doctorsLoginCardview);

        doctorSignInButton = (Button) findViewById(R.id.doctorSignInButton);
        doctorSignUpButton = (Button) findViewById(R.id.signUpAsDoctorButton);
        medicineOwner = (Button) findViewById(R.id.medicineOwnerButton);

        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        welcomeTextAnim.startAnimation(translate);

        doctorsLoginCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, doctorsloginAndRegistration.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, loginPage.class));
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, registerPage.class));
            }
        });
    }
}