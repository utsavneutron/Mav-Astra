package com.example.mavastra_login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;

public class insideFit extends AppCompatActivity implements View.OnClickListener{

    public CardView bmicalculatorCard, macwebviewcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_fit);

        bmicalculatorCard = (CardView) findViewById(R.id.bmicalculatorTile);
        macwebviewcard = (CardView) findViewById(R.id.macTile);


        bmicalculatorCard.setOnClickListener(this);
        macwebviewcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent j;

        switch (view.getId()) {
            case R.id.bmicalculatorTile:
                j = new Intent(this, bmiCalculator.class);
                startActivity(j);
                break;

                case R.id.macTile:
                    j = new Intent(this, utaMac.class);
                    startActivity(j);
                    break;
        }
    }
}