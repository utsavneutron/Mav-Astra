package com.example.mavastra_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mHealth extends AppCompatActivity implements View.OnClickListener {

    public CardView bookappointmentCard, healthtranscriptsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_health);

        bookappointmentCard = (CardView) findViewById(R.id.bookappointmentTile);
        healthtranscriptsCard = (CardView) findViewById(R.id.healthtranscriptsTile);

        bookappointmentCard.setOnClickListener(this);
        healthtranscriptsCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent j;

        switch (view.getId()) {
            case R.id.bookappointmentTile:
                j = new Intent(this, medicalAppointment.class);
                startActivity(j);
                break;

            case R.id.healthtranscriptsTile:
                j = new Intent(this, healthTranscripts.class);
                startActivity(j);
                break;
        }
    }
}