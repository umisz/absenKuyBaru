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

public class SignUp extends Activity {

    EditText editUserBaru, editPassBaru, editConfPassBaru;
    Button btnCreateAccount;

    LoginDatabaseAdapter loginDatabaseAdapter;
    LoginBaru loginBaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.signup);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
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

                if(!userName.equals("") && !password.equals("") && confirmPass.equals(password)) {
                    if(!confirmPass.equals(password)) {
                        Toast.makeText(getApplicationContext(), "Password tidak cocok", Toast.LENGTH_SHORT).show();
                    } else {
                        LoginBaru loginBaru = new LoginBaru(userName, password);
                        loginDatabaseAdapter.insertEntry(loginBaru);
                        Toast.makeText(getApplicationContext(), "Account Successfully Created", Toast.LENGTH_SHORT).show();
                        Intent b = new Intent(SignUp.this, Login.class);
                        startActivity(b);
                    }
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
