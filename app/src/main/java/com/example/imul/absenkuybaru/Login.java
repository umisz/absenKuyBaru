package com.example.imul.absenkuybaru;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Imul on 28-Nov-16.
 */

public class Login extends Activity {
    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        final EditText editTextUserName = (EditText) findViewById(R.id.txtUsername);
        final EditText editTextPassword = (EditText) findViewById(R.id.txtPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the username & password
                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedpassword = loginDatabaseAdapter.getSinlgeEntry(username);

                //check if the stored password match with password entered by user
                if(!password.equals(storedpassword)) {
                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }

                else if(password.equals("") && username.equals("")) {

                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_SHORT).show();

                }

                else {

                    Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_SHORT).show();

                    Intent a = new Intent(Login.this, PilihMenu.class);
                    startActivity(a);

                }
            }
        });
    }
}
