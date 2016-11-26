package com.example.imul.absenkuybaru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText editUserBaru, editPassBaru, editConfPassBaru;
    Button btnCreateAccount;

    LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                if(userName.equals("")||password.equals("")||confirmPass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Semua kolom wajib diisi", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!password.equals(confirmPass)) {
                    Toast.makeText(getApplicationContext(), "Password tidak cocok", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    loginDatabaseAdapter.insertEntry(userName,password);
                    Toast.makeText(getApplicationContext(), "Akun terdaftar", Toast.LENGTH_LONG).show();
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
