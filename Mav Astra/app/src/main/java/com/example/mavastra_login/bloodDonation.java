package com.example.mavastra_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bloodDonation extends AppCompatActivity implements View.OnClickListener{

    public CardView fundCard, fund1Card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donation);

        fundCard = (CardView) findViewById(R.id.blooddonationTile1);
        fund1Card = (CardView) findViewById(R.id.blooddonationTile2);

        fundCard.setOnClickListener(this);
        fund1Card.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.blooddonationTile1:
                i = new Intent(this, blooddonationAppointment.class);
                startActivity(i);
                break;

            case R.id.blooddonationTile2:
                i = new Intent(this, blooddonationAppointment.class);
                startActivity(i);
                break;
        }
    }
}