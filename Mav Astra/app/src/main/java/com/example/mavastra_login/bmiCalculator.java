package com.example.mavastra_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiCalculator extends AppCompatActivity {


    private Button Calculate;
    private EditText Weight, Height;
    private TextView Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        Calculate=findViewById(R.id.bmiBtn);
        Weight = findViewById(R.id.bmiWeight);
        Height = findViewById(R.id.bmiHeight);
        Answer = findViewById(R.id.bmiResult);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getW= Weight.getText().toString();
                String getH= Height.getText().toString();

                float W=Float.parseFloat(getW);
                float H=Float.parseFloat(getH);

                float newH=H*12;
                float bmi =(703*W)/(newH*newH);

                if(bmi<18.5)
                {
                    String data= bmi + "\n" + "Underweight";
                    Answer.setText(data);
                }
                else if(bmi>=18.5&&bmi<25){
                    String data= bmi +"\n" + "Normal";
                    Answer.setText(data);

                }
                else{
                    String data= bmi +"\n"+"Overweight";
                    Answer.setText(data);

                }
            }
        });

    }
}