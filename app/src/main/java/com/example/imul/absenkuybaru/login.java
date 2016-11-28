package com.example.imul.absenkuybaru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText editTextUserName = (EditText) findViewById(R.id.txtUsername);
        String str = editTextUserName.getText().toString();
        final EditText editTextPassword = (EditText) findViewById(R.id.txtPassword);
        String pass = editTextPassword.getText().toString();
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        final String password = helper.searchPass(str);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the username & password
               /* String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                //fetch the password from database for respective username
                String storedPassword = loginDatabaseAdapter.getSingleEntry(username);*/

                //check if the stored password match with password entered by user
                if(pass.equals(password)) {
                    Toast.makeText(login.this, "Login berhasil", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(login.this, "Login gagal", Toast.LENGTH_LONG).show();
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
