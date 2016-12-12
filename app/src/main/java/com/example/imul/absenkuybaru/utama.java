package com.example.imul.absenkuybaru;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class Utama extends Activity {
    Button btnSignIn, btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.utama);


        //get the reffences of buttons
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount) ;

        //set onClick listener on signIn button
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSignIn = new Intent(Utama.this, Login.class);
                startActivity(intentSignIn);
            }
        });
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSignUp = new Intent(Utama.this, SignUp.class);
                startActivity(intentSignUp);
            }
        });
    }
}
