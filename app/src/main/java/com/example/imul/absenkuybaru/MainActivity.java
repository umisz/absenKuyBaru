package com.example.imul.absenkuybaru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {





                        if(txtUsername.getText().toString().equals("putra") && txtPassword.getText().toString().equals("putra")){
                            Intent i = new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(MainActivity.this,"salah", Toast.LENGTH_SHORT);
                        }
                    }
                }
        );
    }
}
