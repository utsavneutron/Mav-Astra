package com.example.mavastra_login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class blooddonationAppointment extends AppCompatActivity {
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blooddonation_appointment);
//
        submitButton = (Button)findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(blooddonationAppointment.this, MainActivity.class);
                Toast.makeText(blooddonationAppointment.this, "Blood Donation appointment booked successfully!\nYou will receive a confirmation shortly.", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}