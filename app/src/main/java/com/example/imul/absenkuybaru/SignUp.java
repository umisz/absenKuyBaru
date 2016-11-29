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

public class SignUp extends AppCompatActivity {

    EditText editUserBaru, editPassBaru, editConfPassBaru;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        loginDatabaseAdapter = new LoginDataBaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();

        editUserBaru = (EditText) findViewById(R.id.editUserBaru);
        editPassBaru = (EditText) findViewById(R.id.editPassBaru);
        editConfPassBaru = (EditText) findViewById(R.id.editConfPassBaru);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editUserBaru.getText().toString();
                String password = editPassBaru.getText().toString();
                String confirmPass = editConfPassBaru.getText().toString();

                if(!userName.equals("") && !password.equals("") && !confirmPass.equals("")) {
                    loginDatabaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_SHORT);
                    Intent b = new Intent(SignUp.this, Login.class);
                    startActivity(b);

                }

                else {

                    Toast.makeText(getApplicationContext(), "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        loginDatabaseAdapter.close();
    }
}
