package com.example.mavastra_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class healthTranscripts extends AppCompatActivity {

    Button btn1;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_transcripts);

        btn1 = findViewById(R.id.healthtranscript1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(healthTranscripts.this, healthTranscripts1.class);
                startActivity(i);
            }
        });

        btn2 = findViewById(R.id.healthtranscript2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(healthTranscripts.this, healthTranscripts2.class);
                startActivity(i);
            }
        });

    }
}