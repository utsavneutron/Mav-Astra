package com.example.mavastra_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mSeva extends AppCompatActivity implements View.OnClickListener{
    public CardView fundCard, blooddonationCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_seva);

        fundCard = (CardView) findViewById(R.id.raisefundsTile);
        blooddonationCard = (CardView) findViewById(R.id.blooddonationTile);

        fundCard.setOnClickListener(this);
        blooddonationCard.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.raisefundsTile:
                i = new Intent(this, raiseFunds.class);
                startActivity(i);
                break;

            case R.id.blooddonationTile:
                i = new Intent(this, bloodDonation.class);
                startActivity(i);
                break;
        }
    }
}