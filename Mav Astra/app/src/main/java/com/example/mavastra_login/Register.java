package com.example.mavastra_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText mFirstName, mLastName, mEmail, mPassword, mPhone;
    Button mRegButton;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar prgBar;
    DatabaseReference netReff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = findViewById(R.id.FirstName);
        mLastName = findViewById(R.id.LastName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);
        mPhone = findViewById(R.id.Phone);
        mRegButton = findViewById(R.id.reg_button);
        mLoginBtn = findViewById(R.id.login_here);

        fAuth = FirebaseAuth.getInstance();
        netReff = FirebaseDatabase.getInstance().getReference().child("Member lodu");
        prgBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        mRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String phonenum = mPhone.getText().toString().trim();
                final String firstname = mFirstName.getText().toString().trim();
                final String lastname = mLastName.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Please enter your email.");
                    mEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    mEmail.setError("Enter  a valid Email");
                    mEmail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mEmail.setError("Please enter password.");
                    return;
                }
                if (password.length() < 6) {
                    mPassword.setError("Password must have more than 6 characters.");
                    return;
                }
                if (phonenum.length() != 10){
                    mPhone.setError("Phone number must have 10 digits. ");
                    return;
                }

                prgBar.setVisibility(View.VISIBLE);

                //Registering user in the firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Congratulations for signing up.", Toast.LENGTH_SHORT).show();
                            userbase user = new userbase(
                                    firstname,
                                    lastname,
                                    email,
                                    phonenum
                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this, "Database created.", Toast.LENGTH_SHORT).show();

                                    }
                                }

                            })
                            ;

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),login.class));
                }
        });
    }
}