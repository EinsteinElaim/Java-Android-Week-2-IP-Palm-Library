package com.moringaschool.palmlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class SignUp extends AppCompatActivity {
    Toolbar toolbar;
    EditText email,password,name;
    CheckBox checkBox;
    ImageButton signUp;
    Button signIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        checkBox = (CheckBox) findViewById(R.id.termsandconditionschkbox);
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);


        signUp = (ImageButton) findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(SignUp.this,"Sign Up Button Clicked",Toast.LENGTH_LONG).show();
            }
        });

        signIn = (Button) findViewById(R.id.signin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, SplashScreen.class);
                startActivity(i);
                Toast.makeText(SignUp.this, "Sign In Button Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}