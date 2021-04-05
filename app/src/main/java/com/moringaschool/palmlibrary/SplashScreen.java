package com.moringaschool.palmlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class SplashScreen extends AppCompatActivity {
    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    ImageButton signIn;
    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        checkBox = (CheckBox)findViewById(R.id.checkbox);

        signIn =(ImageButton)findViewById(R.id.signin);

        signUp = (Button) findViewById(R.id.signup);

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(SplashScreen.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreen.this, SignUp.class);
                startActivity(i);
                Toast.makeText(SplashScreen.this,"Sign Up Button Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}