package com.example.mavastra_login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;

public class mDine extends AppCompatActivity implements View.OnClickListener {

    public CardView connectioncafeCard, maverickcafeCard, starbucksCard, utaplazaCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_dine);

        connectioncafeCard = (CardView) findViewById(R.id.connectioncafeTile);
        maverickcafeCard = (CardView) findViewById(R.id.maverickcafeTile);
        starbucksCard = (CardView) findViewById(R.id.starbucksTile);
        utaplazaCard = (CardView) findViewById(R.id.utaplazaTile);

        connectioncafeCard.setOnClickListener(this);
        maverickcafeCard.setOnClickListener(this);
        starbucksCard.setOnClickListener(this);
        utaplazaCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.connectioncafeTile:
                i = new Intent(this, connectionCafe.class);
                startActivity(i);
                break;

            case R.id.maverickcafeTile:
                i = new Intent(this, maverickcafe.class);
                startActivity(i);
                break;
            case R.id.starbucksTile:
                i = new Intent(this, starbucks.class);
                startActivity(i);
                break;

            case R.id.utaplazaTile:
                i = new Intent(this, utaplaza.class);
                startActivity(i);
                break;
        }

    }
}