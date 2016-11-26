package com.example.imul.absenkuybaru;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Utama extends AppCompatActivity {
    Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utama);

        //get the reffences of buttons
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        //set onClick listener on signUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intentSignUp = new Intent(Utama.this, SignUp.class);
                startActivity(intentSignUp);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSignIn = new Intent(Utama.this, Login.class);
                startActivity(intentSignIn);
            }
        });
    }
}
