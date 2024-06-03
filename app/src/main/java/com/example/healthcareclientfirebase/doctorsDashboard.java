package com.example.healthcareclientfirebase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class doctorsDashboard extends AppCompatActivity {

    CardView appoinmentCardView;
    CardView myPatientCardview;
    Button logoutbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctors_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        appoinmentCardView = (CardView) findViewById(R.id.appoinmentCard);
        myPatientCardview = (CardView) findViewById(R.id.myPatientCardview);
        logoutbutton = (Button) findViewById(R.id.logoutButton);

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(doctorsDashboard.this);
                builder.setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked "Yes", logout and finish activity
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(doctorsDashboard.this, doctorSignIn.class));
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked "No", dismiss dialog
                                dialog.dismiss();
                            }
                        });
                // Create the AlertDialog object and show it
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        appoinmentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorsDashboard.this, PatientAppointementsActivity.class));
            }
        });

        myPatientCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(doctorsDashboard.this, AcceptedBookingActivity.class));
            }
        });
    }
}