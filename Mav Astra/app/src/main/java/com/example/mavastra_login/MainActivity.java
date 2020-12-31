package com.example.mavastra_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView sevaCard, payCard, medicalCard, tileCard, dineoncampusCard, utasosCard, utafitCard, utaqCard;
    String fName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();

    public Button logoutCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sevaCard = (CardView) findViewById(R.id.sevaTile);
        payCard = (CardView) findViewById(R.id.payTile);
        medicalCard = (CardView) findViewById(R.id.medicalTile);
        tileCard = (CardView) findViewById(R.id.todayTile);
        dineoncampusCard = (CardView) findViewById(R.id.dineoncampusTile);
        utasosCard = (CardView) findViewById(R.id.utasosTile);
        utafitCard = (CardView) findViewById(R.id.fitTile);
        utaqCard = (CardView) findViewById(R.id.utaqTile);

        logoutCard =  findViewById(R.id.logoutbtn);

//        Log.d("TAG")



        sevaCard.setOnClickListener(this);
        payCard.setOnClickListener(this);
        medicalCard.setOnClickListener(this);
        tileCard.setOnClickListener(this);
        tileCard.setOnClickListener(this);
        dineoncampusCard.setOnClickListener(this);
        utasosCard.setOnClickListener(this);
        utafitCard.setOnClickListener(this);
        utaqCard.setOnClickListener(this);

        logoutCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.sevaTile:
                i = new Intent(this, mSeva.class);
                startActivity(i);
                break;

            case R.id.payTile:
                i = new Intent(this, MavPay.class);
                startActivity(i);
                break;

            case R.id.medicalTile:
                i = new Intent(this, mHealth.class);
                startActivity(i);
                break;

            case R.id.todayTile:
                i = new Intent(this, insideToday.class);
                startActivity(i);
                break;

            case R.id.dineoncampusTile:
                i = new Intent(this, mDine.class);
                startActivity(i);
                break;

            case R.id.utasosTile:
                i = new Intent(this, utaSos.class);
                startActivity(i);
                break;

            case R.id.fitTile:
                i = new Intent(this, insideFit.class);
                startActivity(i);
                break;

            case R.id.utaqTile:
                i = new Intent(this, utaQ.class);
                startActivity(i);
                break;


            case R.id.logoutbtn:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login.class));
                Toast.makeText(MainActivity.this, "Successfully logged out.", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
    }
}