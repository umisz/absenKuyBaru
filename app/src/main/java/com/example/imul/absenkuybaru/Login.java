package com.example.imul.absenkuybaru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Imul on 28-Nov-16.
 */

public class Login extends AppCompatActivity {
    LoginDataBaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText editTextUserName = (EditText) findViewById(R.id.txtUsername);
        final EditText editTextPassword = (EditText) findViewById(R.id.txtPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        loginDatabaseAdapter = new LoginDataBaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the username & password
                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                //fetch the password from database for respective username
                String storedPassword = loginDatabaseAdapter.getSinlgeEntry(username);

                //check if the stored password match with password entered by user
                if(!password.equals(storedPassword)) {

                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_LONG).show();

                }

                else if(password.equals("") && username.equals("")) {

                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_LONG).show();

                }

                else {

                    Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_LONG).show();

                    Intent a = new Intent(Login.this, welcome.class);
                    startActivity(a);

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //close database
        loginDatabaseAdapter.close();
    }
}